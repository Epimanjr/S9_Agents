package fr.miage.supermarche.behavior;

import fr.miage.supermarche.util.MessageInterne;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Antoine NOSAL
 * @author Maxime BLAISE
 * @author Guillaume DÉNISSE
 * @author Geoffrey GAILLARD
 */
public class FournisseurBehavior extends CyclicBehaviour{

    public FournisseurBehavior(Agent a) {
        super(a);
    }
    
    @Override
    public void action() {
        ACLMessage aclMsg = this.getAgent().receive();
        
        // On attend de recevoir des messages
        if (aclMsg != null) {
            try {
                // Si on reçoit un message interne
                MessageInterne recu = (MessageInterne) aclMsg.getContentObject();

                switch (recu.type) {
                    case demandeReapprov :
                    
                        break;
                    default:
                        break;
                }

            } catch (UnreadableException e) {
                Logger.getLogger(ClientBehavior.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
}
