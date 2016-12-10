package fr.miage.supermarche.test;

import fr.miage.agents.api.message.Message;
import fr.miage.agents.api.message.negociation.InitierAchat;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
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
    //private Map<UUID, SessionAchat> sessionsActives;
    public FournisseurTestBehavior(Agent a) {
        super(a);
        //this.sessionsActives = new HashMap<>();
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
                        System.out.println("[FOURNISSEUR_TEST] Demande d'achat reçue");
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
