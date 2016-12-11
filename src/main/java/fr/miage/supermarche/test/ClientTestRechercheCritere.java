/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.supermarche.test;

import fr.miage.agents.api.message.recherche.Rechercher;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import java.io.IOException;
import java.io.Serializable;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kangoula
 */
public class ClientTestRechercheCritere extends OneShotBehaviour {

    public ClientTestRechercheCritere(Agent a) {
        super(a);
    }

    @Override
    public void action() {
        System.out.println("[CLIENT_TEST] Recherche par critères");
        Rechercher crit = new Rechercher();
        crit.nomCategorie = "High-Tech";
        crit.prixMax = 150;
        crit.prixMin = 100;
        crit.marque = "";
        crit.session = UUID.randomUUID();
        this.envoyerMessage(crit);
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
