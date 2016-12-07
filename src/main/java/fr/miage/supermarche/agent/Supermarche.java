package fr.miage.supermarche.agent;

import jade.core.Agent;

/**
 *
 * @author Antoine NOSAL
 * @author Maxime BLAISE
 * @author Guillaume DÉNISSE
 * @author Geoffrey GAILLARD
 */
public class Supermarche extends Agent {

    protected void setUp() {
        System.out.println("Je suis une super supermarché dont le nom est : " + this.getLocalName());
    }
    
}
