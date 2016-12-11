/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.supermarche.test;

import fr.miage.agents.api.message.relationclientsupermarche.Achat;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kangoula
 */
public class ClientTestAchat extends OneShotBehaviour {

    public ClientTestAchat(Agent a) {
        super(a);
    }

    @Override
    public void action() {
        System.out.println("[CLIENT_TEST] Achat");
        Achat a = new Achat();
        Map<Long, Integer> courses = new HashMap<>();
        courses.put(new Long(1), 1);
        a.Session = UUID.randomUUID();
        a.listeCourses = courses;
        this.envoyerMessage(a);
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
