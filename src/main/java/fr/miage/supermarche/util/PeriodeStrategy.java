package fr.miage.supermarche.util;

/**
 *
 * @author Antoine NOSAL
 * @author Maxime BLAISE
 * @author Guillaume DÉNISSE
 * @author Geoffrey GAILLARD
 */
public interface PeriodeStrategy {

    /**
     * Définit ou non une nouvelle période en
     * fonction d'une période en paramètre
     * @param p Période à traiter
     * @return 
     */
    public Periode define(Periode p);
    
}
