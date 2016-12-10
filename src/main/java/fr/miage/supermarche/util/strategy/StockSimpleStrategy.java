package fr.miage.supermarche.util.strategy;

import fr.miage.supermarche.behavior.SpermarcheBehavior;
import fr.miage.supermarche.persist.Produit;
import fr.miage.supermarche.util.Stock;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Définit une stratégie simple de gestion du stock
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
     * Quantités minimum en stock pour chaque produit
     * référenceProduit -> qte minimum
     */
    private Map<String, Integer> qteMinProduits;

    public StockSimpleStrategy() {
        this.qteMinProduits = new HashMap<>();
        this.initQteMinProduits();
    }
    
    /**
     * Définit une quantité minimum souhaitée en stock pour chaque produit
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
                    s.aCommander.put(produit.getId(), qteManquante);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SpermarcheBehavior.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
