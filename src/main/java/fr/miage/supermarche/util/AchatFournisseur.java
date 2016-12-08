package fr.miage.supermarche.util;

import fr.miage.supermarche.util.strategy.AchatFournisseurStrategy;

/**
 * 
 * @author Antoine NOSAL
 * @author Maxime BLAISE
 * @author Guillaume DÉNISSE
 * @author Geoffrey GAILLARD
 */
public class AchatFournisseur {

    /**
     * Stratégie
     */
    private AchatFournisseurStrategy strategy;

    public AchatFournisseur() {
    }

    public AchatFournisseurStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(AchatFournisseurStrategy strategy) {
        this.strategy = strategy;
    }
    
}
