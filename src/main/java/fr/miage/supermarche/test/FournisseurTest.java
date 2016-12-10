package fr.miage.supermarche.test;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Antoine NOSAL
 */
public class FournisseurTest extends Agent {

    protected void setup() {
        System.out.println("\n[FOURNISSEUR_TEST] Lancement de '" + this.getLocalName() + "'");

        /**
         * Enregistrement l'agent dans les pages jaunes
         */
        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(getAID());
        ServiceDescription sd = new ServiceDescription();
        sd.setType("fournisseur");
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
        FournisseurTestBehavior fournisseurTest = new FournisseurTestBehavior(this);
        
        List<Behaviour> behaviors = Arrays.asList(fournisseurTest);
        
        behaviors.forEach(it -> addBehaviour(it));
    }
    
}
