package fr.miage.supermarche.util.strategy;

import fr.miage.supermarche.util.Periode;

/**
 * Définit une stratégie de définition des périodes
 * (standard, soldes fêtes, soldes flottantes)
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
