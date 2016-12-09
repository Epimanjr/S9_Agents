package fr.miage.supermarche.util.strategy;

import fr.miage.supermarche.util.AchatFournisseur;

/**
 *
 * @author Antoine NOSAL
 * @author Maxime BLAISE
 * @author Guillaume DÉNISSE
 * @author Geoffrey GAILLARD
 */
public class AchatFournisseurSimpleStrategy implements AchatFournisseurStrategy {
    
    @Override
    public boolean approuver(AchatFournisseur af) {
        // En fonction du produit (af.getIdProduit) et du prix (af.getPrix),
        // de la quantité souhaitée et de la quantité disponible chez le fournisseur
        // la stratégie nous dit si on achète ou non
        return false;
    }

}
