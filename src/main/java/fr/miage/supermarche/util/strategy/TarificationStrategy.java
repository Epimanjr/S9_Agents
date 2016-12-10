package fr.miage.supermarche.util.strategy;

import fr.miage.supermarche.persist.Produit;
import fr.miage.supermarche.util.Tarification;
import java.util.List;

/**
 * Définit une stratégie de tarification
 * (Tarification = Prix de Vente Hors Taxes des produits)
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
    public void update(Tarification p, List<Produit> produits);
    
}
