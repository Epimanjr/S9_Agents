/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.supermarche.test;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.ThreadedBehaviourFactory;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author kangoula
 */
public class ClientTest extends Agent{
    
    private ThreadedBehaviourFactory tbf = new ThreadedBehaviourFactory();
    
    protected void setup() {
        System.out.println("\n[CLIENT_TEST] Lancement de '" + this.getLocalName() + "'");

        /**
         * Enregistrement l'agent dans les pages jaunes
         */
        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(getAID());
        ServiceDescription sd = new ServiceDescription();
        sd.setType("client");
        sd.setName(this.getLocalName());
        dfd.addServices(sd);
        try {
            DFService.register(this, dfd);
        } catch (FIPAException fe) {
            fe.printStackTrace();
        }
        
        /**
         * Instanciation des behaviors
         */
        List<Behaviour> behaviors = Arrays.asList(
                new ClientTestBehavior(this), 
                new ClientTestRechercheId(this), 
                new ClientTestRechercheCritere(this),
                new ClientTestAchat(this));
        
        behaviors.forEach(it -> addBehaviour(tbf.wrap(it)));
    }
}
