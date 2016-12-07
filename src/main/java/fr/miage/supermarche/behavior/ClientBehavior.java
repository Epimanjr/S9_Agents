/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.supermarche.behavior;

import fr.miage.agents.api.message.Message;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

/**
 *
 * @author Guillaume DENIS
 */
public class ClientBehavior extends CyclicBehaviour{

    @Override
    public void action() {
        ACLMessage aclMsg = this.getAgent().receive();

        // On gère le message reçu par la plateforme
        if(aclMsg != null){
            try {
                // Récupèration du Message de l'API
                Message msg = (Message)aclMsg.getContentObject();

                switch(msg.type){
                    case Recherche:
                        //TODO gérer la recherche par rapport à des critères
                        break;
                    default:
                        break;
                }

            } catch (UnreadableException e) {
                e.printStackTrace();
            }

        }
    }
    
    
}
