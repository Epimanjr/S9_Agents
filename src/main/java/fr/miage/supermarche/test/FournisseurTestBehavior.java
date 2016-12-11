package fr.miage.supermarche.test;

import fr.miage.agents.api.message.Message;
import fr.miage.agents.api.message.TypeMessage;
import fr.miage.agents.api.message.negociation.FinaliserAchat;
import fr.miage.agents.api.message.negociation.InitierAchat;
import fr.miage.agents.api.message.negociation.ResultatFinalisationAchat;
import fr.miage.agents.api.message.negociation.ResultatInitiationAchat;
import fr.miage.supermarche.persist.Produit;
import fr.miage.supermarche.util.SessionAchat;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
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
public class FournisseurTestBehavior extends CyclicBehaviour {

    /**
     * Ensemble des sessions d'échanges avec les supermarchés
     */
    private Map<UUID, SessionAchat> sessionsActives;
    
    public FournisseurTestBehavior(Agent a) {
        super(a);
        this.sessionsActives = new HashMap<>();
    }

    @Override
    public void action() {
        try {
            ACLMessage aclMsg = this.getAgent().receive();

            // On attend de recevoir des messages
            if (aclMsg != null) {
                // Si on reçoit un message

                // Si c'est un message (envoyé par un agent externe par exemple un supermarché)
                Message recu = (Message) aclMsg.getContentObject();
                switch (recu.type) {
                    case InitierAchat:
                        InitierAchat ia = (InitierAchat) recu;
                        System.out.println("\n[FOURNISSEUR_TEST] Initiation d'achat reçue");
                        ResultatInitiationAchat ria = new ResultatInitiationAchat();
                        ria.success = true;
                        ria.session = ia.session;
                        ria.quantiteDisponible = ia.quantite;
                        Optional<Produit> produit1 = Produit.getById(ia.idProduit);
                        if (produit1.isPresent()) {
                            ria.prixFixe = produit1.get().getPrixProduit() * 1.10f;
                        }
                        this.sessionsActives.put(ria.session, new SessionAchat(ia.idProduit, ia.quantite, TypeMessage.Aide));
                        this.envoyerMessage(ria);
                        break;
                    case FinaliserAchat:
                        FinaliserAchat fa = (FinaliserAchat) recu;
                        ResultatFinalisationAchat rfa = new ResultatFinalisationAchat();
                        rfa.session = fa.session;
                        rfa.idProduit = this.sessionsActives.get(fa.session).getIdProduit();
                        rfa.quantiteProduit = this.sessionsActives.get(fa.session).getQteSouhaitee();
                        Optional<Produit> produit2 = Produit.getById(rfa.idProduit);
                        if (produit2.isPresent()) {
                            rfa.prixFinal = produit2.get().getPrixProduit() * 1.10f;
                        }
                        System.out.println("[FOURNISSEUR_TEST] Demande de finalisation d'achat reçue (produit n°" + rfa.idProduit);
                        this.envoyerMessage(rfa);
                        break;
                    default:
                        break;
                }

            }
        } catch (UnreadableException ex) {
            Logger.getLogger(FournisseurTestBehavior.class.getName()).log(Level.SEVERE, null, ex);
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
            msg.addReceiver(new AID("supermarche", AID.ISLOCALNAME));
            msg.setContentObject(s);

            // envoit du message
            this.getAgent().send(msg);

        } catch (IOException ex) {
            Logger.getLogger(FournisseurTestBehavior.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
