package fr.miage.supermarche.behavior;

import fr.miage.agents.api.message.Message;
import fr.miage.agents.api.message.TypeMessage;
import fr.miage.agents.api.message.negociation.AnnulerAchat;
import fr.miage.agents.api.message.negociation.FinaliserAchat;
import fr.miage.agents.api.message.negociation.InitierAchat;
import fr.miage.agents.api.message.negociation.NegocierPrix;
import fr.miage.agents.api.message.negociation.ResultatAnnulationAchat;
import fr.miage.agents.api.message.negociation.ResultatFinalisationAchat;
import fr.miage.agents.api.message.negociation.ResultatInitiationAchat;
import fr.miage.agents.api.message.negociation.ResultatNegociation;
import fr.miage.supermarche.persist.RequetesInternes;
import fr.miage.supermarche.util.AchatFournisseur;
import fr.miage.supermarche.util.MessageInterne;
import fr.miage.supermarche.util.SessionAchat;
import fr.miage.supermarche.util.strategy.AchatFournisseurSimpleStrategy;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Antoine NOSAL
 * @author Maxime BLAISE
 * @author Guillaume DÉNISSE
 * @author Geoffrey GAILLARD
 */
public class FournisseurBehavior extends CyclicBehaviour {

    /**
     * Représente un achat fournisseur Le comportement est définit par une
     * stratégie
     */
    private AchatFournisseur achatFournisseur;

    /**
     * Ensemble des sessions d'échanges avec les fournisseurs
     */
    private Map<UUID, SessionAchat> sessionsActives;

    /**
     * Construit un comportement fournisseur depuis un agent
     * (stratégie simple prédéfinie)
     *
     * @param a Agent initial qui adoptera ce comportement
     */
    public FournisseurBehavior(Agent a) {
        super(a);
        this.achatFournisseur = new AchatFournisseur();
        this.achatFournisseur.setStrategy(new AchatFournisseurSimpleStrategy());
    }
    
    /**
     * Construit un comportement fournisseur depuis un agent
     *
     * @param a     Agent initial qui adoptera ce comportement
     * @param af    Gestion des achats fournisseur
     */
    public FournisseurBehavior(Agent a, AchatFournisseur af) {
        super(a);
        this.achatFournisseur = af;
    }

    @Override
    public void action() {
        try {
            ACLMessage aclMsg = this.getAgent().receive();

            // On attend de recevoir des messages
            if (aclMsg != null) {
                // Si on reçoit un message
                if (aclMsg.getContentObject() instanceof MessageInterne) {
                    // Si c'est un message interne (envoyé via SupermarcheBehavior par exemple)
                    MessageInterne recu = (MessageInterne) aclMsg.getContentObject();
                    switch (recu.type) {
                        case demandeReapprov:
                            System.out.println("demandeReapprov");
                            // ETAPE 0 : On reçoit une demande de réapprovisionnement
                            // Pour tous les éléments de la liste aCommander
                            for (Map.Entry<Integer, Integer> aCommander : recu.aCommander.entrySet()) {
                                // ETAPTE 1 : On envoie une demande InitierAchat aux fournisseurs
                                UUID UUIDsessionActive = UUID.randomUUID();
                                InitierAchat ia = new InitierAchat();
                                ia.session = UUIDsessionActive;
                                ia.idProduit = aCommander.getKey();
                                ia.quantite = aCommander.getValue();
                                this.envoyerMessage(ia);
                                SessionAchat sa = new SessionAchat(ia.idProduit, ia.quantite, TypeMessage.InitierAchat);
                                this.sessionsActives.put(UUIDsessionActive, sa);
                            }
                            break;
                        default:
                            break;
                    }
                } else if (aclMsg.getContentObject() instanceof Message) {
                    // Si c'est un message (envoyé par un agent externe par exemple un fournisseur)
                    Message recu = (Message) aclMsg.getContentObject();
                    switch (recu.type) {
                        case ResultatInitiationAchat:
                            // ETAPE 2 : On reçoit un résultat avec une 1ère proposition de prix
                            // (la stratégie va nous faire ou non entamer une négociation)
                            ResultatInitiationAchat ria = (ResultatInitiationAchat) recu;
                            if (ria.success) {
                                SessionAchat sa = this.sessionsActives.get(ria.session);
                                this.etudierProposition(sa, ria.session, ria.prixFixe, ria.quantiteDisponible);
                            }
                            break;
                        case ResultatFinalisationAchat:
                            // ETAPE 4 : Si on est OK, on finalise l'achat
                            ResultatFinalisationAchat rfa = (ResultatFinalisationAchat) recu;
                            SessionAchat sa_rfa = this.sessionsActives.get(rfa.session);
                            Integer idProduit = Integer.parseInt(rfa.idProduit + "");
                            Integer qteAchetee = rfa.quantiteProduit;
                            RequetesInternes.ajouterProduit(idProduit, qteAchetee);
                            this.sessionsActives.remove(rfa.session);
                            break;
                        case ResultatNegociation:
                            // ETAPE 3 : Si on a tenté de négocier, il faut traiter la nouvelle proposition
                            ResultatNegociation rn = (ResultatNegociation) recu;
                            SessionAchat sa_rn = this.sessionsActives.get(rn.session);
                            if (rn.estAccepte) {
                                // Si la négociation est accepté, on étudie la proposition
                                this.etudierProposition(sa_rn, rn.session, rn.prixNegocie, rn.quantiteDisponible);
                            } else {
                                // Sinon, on arrête le massacre, on demande l'annulation de l'achat
                                AnnulerAchat aa = new AnnulerAchat();
                                aa.session = rn.session;
                                this.envoyerMessage(aa);
                            }
                            break;
                        case ResultatAnnulationAchat:
                            // ETAPE 4bis : Si on nous confirme que l'achat est annulé,
                            // On supprime la session
                            ResultatAnnulationAchat raa = (ResultatAnnulationAchat) recu;
                            SessionAchat sa_raa = this.sessionsActives.get(raa.session);
                            this.sessionsActives.remove(raa.session);
                            break;
                        default:
                            break;
                    }
                }

            }
        } catch (UnreadableException ex) {
            Logger.getLogger(FournisseurBehavior.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void etudierProposition(SessionAchat sa, UUID session, float prix, Integer qteDispo) {
        this.achatFournisseur.setIdProduit(sa.getIdProduit());
        this.achatFournisseur.setPrixProposeParFournisseur(prix);
        this.achatFournisseur.setQteSouhaitee(sa.getQteSouhaitee());
        this.achatFournisseur.setQteDisponibleChezFournisseur(qteDispo);
        if (this.achatFournisseur.approuver()) {
            // Si l'achat est approuvé selon la stratégie
            FinaliserAchat fa = new FinaliserAchat();
            fa.session = session;
            this.envoyerMessage(fa);
        } else {
            // Si on est pas d'accord
            if (this.achatFournisseur.getPrixANegocier() == (-1)) {
                // Si le fournisseur n'avait pas la quantité suffisante
                AnnulerAchat aa = new AnnulerAchat();
                aa.session = session;
                this.envoyerMessage(aa);
            } else {
                // Si le fournisseur a la bonne quantité mais est trop cher,
                // on tente une nouvelle négociation
                NegocierPrix ng = new NegocierPrix();
                ng.session = session;
                ng.idProduit = sa.getIdProduit();
                ng.prixDemande = this.achatFournisseur.getPrixANegocier();
                ng.quantiteDemande = sa.getQteSouhaitee();
                this.envoyerMessage(ng);
            }
        }
    }

    /**
     * Envoi le message aux agents
     *
     * @param s l'objet à envoyer
     */
    private void envoyerMessage(Serializable s) {
        try {
            // création du message pour JADE
            ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
            msg.setContentObject(s);

            // envoit du message
            this.getAgent().send(msg);

        } catch (IOException ex) {
            Logger.getLogger(ClientBehavior.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
