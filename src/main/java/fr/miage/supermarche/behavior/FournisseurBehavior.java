package fr.miage.supermarche.behavior;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;

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
        System.out.println("test2");
    }
    
}
