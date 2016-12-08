package fr.miage.supermarche.util;

import fr.miage.supermarche.behavior.SpermarcheBehavior;
import fr.miage.supermarche.persist.Produit;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Si le stock disponible est inférieur à la moitié de la quantité souhaitée
 * minimale souhaitée Alors on doit se réapprovisionner
 *
 * @author Antoine NOSAL
 * @author Maxime BLAISE
 * @author Guillaume DÉNISSE
 * @author Geoffrey GAILLARD
 */
public class StockSimpleStrategy implements StockStrategy {

    /**
     * Quantités minimum pour chaque produit
     */
    private Map<String, Integer> qteMinProduits;

    public StockSimpleStrategy() {
        this.initQteMinProduits();
    }
    
    /**
     * Définit une quantité minimum souhaitée pour chaque produit
     */
    public void initQteMinProduits() {
        this.qteMinProduits.put("BOBI16", 250);
        this.qteMinProduits.put("BOEA901", 100);
        this.qteMinProduits.put("BOMI952", 150);
        this.qteMinProduits.put("BOSN991", 50);
        this.qteMinProduits.put("BOWH188", 450);
    }
    
    @Override
    public void analyse(Stock s) {
        int qteManquante;
        try {
            // Pour chaque quantité minimale par produit
            for (Map.Entry<String, Integer> qteMinProduit : this.qteMinProduits.entrySet()) {
                Produit produit = Produit.getByReference(qteMinProduit.getKey());
                // On utilise la stratégie (définie en début de classe)
                if (produit.getStock() < qteMinProduit.getValue() / 2) {
                    qteManquante = qteMinProduit.getValue() - produit.getStock();
                    //TODO : Référence produit doit être un INTEGER
                    //s.aCommander.put(produit.getReference(), qteManquante);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SpermarcheBehavior.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
