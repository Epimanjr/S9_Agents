package fr.miage.supermarche.util.strategy;

import fr.miage.supermarche.util.Stock;

/**
 *
 * @author Antoine NOSAL
 * @author Maxime BLAISE
 * @author Guillaume DÉNISSE
 * @author Geoffrey GAILLARD
 */
public interface StockStrategy {

    /**
     * Analyse un stock du supermarché
     * (met à jour les produits à réapprovisionner)
     * @param s Stock à analyser
     * @return 
     */
    public void analyse(Stock s);
    
    public void lancerReapprov(Stock s);
    
}
