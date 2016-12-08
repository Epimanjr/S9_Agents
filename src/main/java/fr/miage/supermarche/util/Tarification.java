package fr.miage.supermarche.util;

import fr.miage.supermarche.util.strategy.TarificationStrategy;

/**
 * Classe de gestion des stocks
 * (s'appuie sur une stratégie à définir)
 * @author Antoine NOSAL
 * @author Maxime BLAISE
 * @author Guillaume DÉNISSE
 * @author Geoffrey GAILLARD
 */
public class Tarification{
    
    /**
     * Stratégie de gestion des tarifs
     */
    private TarificationStrategy strategy;
    
    public Tarification() {
    }

    /**
     * Met à jour les tarifs
     * @return 
     */
    public void update() {
        this.strategy.update(this);
    }

    public TarificationStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(TarificationStrategy strategy) {
        this.strategy = strategy;
    }

}
