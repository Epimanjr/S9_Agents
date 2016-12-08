package fr.miage.supermarche.util;

import fr.miage.supermarche.util.strategy.StockStrategy;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe de gestion des stocks
 * (s'appuie sur une stratégie à définir)
 * @author Antoine NOSAL
 * @author Maxime BLAISE
 * @author Guillaume DÉNISSE
 * @author Geoffrey GAILLARD
 */
public class Stock{
    
    /**
     * Stratégie de gestion
     */
    private StockStrategy strategy;
    
    /**
     * Liste des produits à commander/réapprovisionner
     * ID du produit -> qte à commander
     */
    public Map<Integer,Integer> aCommander;
    
    public Stock() {
        this.aCommander = new HashMap<>();
    }

    /**
     * Analyse un stock du supermarché
     * (met à jour la map aCommander)
     * @param s Stock à analyser
     * @return 
     */
    public void analyse() {
        this.strategy.analyse(this);
    }

    public StockStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(StockStrategy strategy) {
        this.strategy = strategy;
    }

    public Map<Integer, Integer> getaCommander() {
        return aCommander;
    }

    public void setaCommander(Map<Integer, Integer> aCommander) {
        this.aCommander = aCommander;
    }
    
}
