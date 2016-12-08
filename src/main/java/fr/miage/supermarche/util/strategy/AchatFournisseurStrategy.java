package fr.miage.supermarche.util.strategy;

import fr.miage.supermarche.util.AchatFournisseur;

/**
 *
 * @author Antoine NOSAL
 * @author Maxime BLAISE
 * @author Guillaume DÉNISSE
 * @author Geoffrey GAILLARD
 */
public interface AchatFournisseurStrategy {

    /**
     * Met à jour les tarifs
     * @param p Période à traiter
     * @return 
     */
    public void todo(AchatFournisseur af);
    
}
