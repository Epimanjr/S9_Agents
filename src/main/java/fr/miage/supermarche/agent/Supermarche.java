package fr.miage.supermarche.agent;

import fr.miage.supermarche.behavior.ClientBehavior;
import fr.miage.supermarche.behavior.FournisseurBehavior;
import fr.miage.supermarche.behavior.SpermarcheBehavior;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.core.behaviours.CyclicBehaviour;
import java.util.Arrays;
import java.util.List;

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
        
        List<Behaviour> behaviors = Arrays.asList(new ClientBehavior(), new FournisseurBehavior(), new SpermarcheBehavior(this, 6000));
        
        behaviors.forEach(it -> addBehaviour(it));
    }

}
