package fr.miage.supermarche.agent;

import jade.core.Agent;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.DFService;
import jade.domain.FIPAException;
/**
 *
 * @author Antoine NOSAL
 * @author Maxime BLAISE
 * @author Guillaume DÉNISSE
 * @author Geoffrey GAILLARD
 */
public class Supermarche extends Agent {

    protected void setup() {
        System.out.println("Je suis une super supermarché dont le nom est : " + this.getLocalName());

        //enregistre l'agent dans les pages jaunes
        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(getAID());
        ServiceDescription sd = new ServiceDescription();
        sd.setType("supermarche");
        sd.setName(this.getLocalName());
        dfd.addServices(sd);
        try {
            DFService.register(this, dfd);
        } catch (FIPAException fe) {
            fe.printStackTrace();
        }
    }

}
