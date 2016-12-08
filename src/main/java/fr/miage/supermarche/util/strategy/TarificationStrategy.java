package fr.miage.supermarche.util.strategy;

import fr.miage.supermarche.util.Tarification;

/**
 *
 * @author Antoine NOSAL
 * @author Maxime BLAISE
 * @author Guillaume DÉNISSE
 * @author Geoffrey GAILLARD
 */
public interface TarificationStrategy {

    /**
     * Met à jour les tarifs
     * @param p Période à traiter
     * @return 
     */
    public void update(Tarification p);
    
}
