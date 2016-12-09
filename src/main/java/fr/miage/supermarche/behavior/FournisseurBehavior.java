package fr.miage.supermarche.behavior;

import fr.miage.agents.api.message.Message;
import fr.miage.agents.api.message.TypeMessage;
import fr.miage.agents.api.message.negociation.FinaliserAchat;
import fr.miage.agents.api.message.negociation.InitierAchat;
import fr.miage.agents.api.message.negociation.ResultatInitiationAchat;
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
     *
     */
    private AchatFournisseur achatFournisseur;

    /**
     * 
     */
    private Map<UUID, SessionAchat> sessionsActives;
    
    /**
     * Construit un comportement fournisseur depuis un agent
     *
     * @param a Agent initial qui adoptera ce comportement
     */
    public FournisseurBehavior(Agent a) {
        super(a);
        this.achatFournisseur = new AchatFournisseur();
        this.achatFournisseur.setStrategy(new AchatFournisseurSimpleStrategy());
    }
    
    @Override
    public void action() {
        try {
            ACLMessage aclMsg = this.getAgent().receive();

            // On attend de recevoir des messages
            if (aclMsg != null) {
                if (aclMsg.getContentObject() instanceof MessageInterne) {
                    // Si c'est un message interne (envoyé via SupermarcheBehavior)
                    MessageInterne recu = (MessageInterne) aclMsg.getContentObject();
                    switch (recu.type) {
                        case demandeReapprov:
                            // Pour tous les éléments de la liste aCommander
                            for (Map.Entry<Integer, Integer> aCommander : recu.aCommander.entrySet()) {
                                // InitierAchat
                                UUID UUIDsessionActive = UUID.randomUUID();
                                InitierAchat ia = new InitierAchat();
                                ia.session = UUIDsessionActive;
                                ia.idProduit = aCommander.getKey();
                                ia.quantite = aCommander.getValue();
                                this.envoyerMessage(ia);
                                SessionAchat sa = new SessionAchat(Integer.parseInt(ia.idProduit + ""), ia.quantite, TypeMessage.InitierAchat);
                                this.sessionsActives.put(UUIDsessionActive, sa);
                                // --> Résultat
                                // Negocier prix (n fois)
                                // --> Résultat (n fois)
                                // FinaliserAchat ou AnnulerAchat en fonction de la stratégie
                                // --> Résultat
                            }
                            break;
                        default:
                            break;
                    }
                } else if (aclMsg.getContentObject() instanceof Message) {
                    // Si c'est un message (envoyé par un agent externe)
                    Message recu = (Message) aclMsg.getContentObject();
                    switch (recu.type) {
                        case ResultatInitiationAchat:
                            // Pour tous les éléments de la liste aCommander
                            ResultatInitiationAchat ria = (ResultatInitiationAchat) recu;
                            if (ria.success) {
                                SessionAchat sa = this.sessionsActives.get(ria.session);
                                this.achatFournisseur.setIdProduit(sa.getIdProduit());
                                this.achatFournisseur.setPrix(ria.prixFixe);
                                this.achatFournisseur.setQteSouhaitee(sa.getQteSouhaitee());
                                this.achatFournisseur.setQteDisponibleChezFournisseur(ria.quantiteDisponible);
                                if (this.achatFournisseur.approuver()) {
                                    // Si l'achat est approuvé selon la startégie
                                    FinaliserAchat fa = new FinaliserAchat();
                                    fa.session = ria.session;
                                    this.envoyerMessage(fa);
                                } else {
                                    // Si on est pas d'accord, on doit négocier
                                }
                            }
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
