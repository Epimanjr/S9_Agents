package fr.miage.supermarche.util.strategy;

import fr.miage.supermarche.behavior.SupermarcheBehavior;
import fr.miage.supermarche.persist.Produit;
import fr.miage.supermarche.util.Stock;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Définit une stratégie simple de gestion du stock Si le stock disponible est
 * inférieur à (seuil * qteMin souhaitée) Alors on doit se réapprovisionner
 *
 * @author Antoine NOSAL
 * @author Maxime BLAISE
 * @author Guillaume DÉNISSE
 * @author Geoffrey GAILLARD
 */
public class StockSimpleStrategy implements StockStrategy {

    /**
     * Quantités minimum en stock pour chaque produit référenceProduit -> qte
     * minimum
     */
    private Map<String, Integer> qteMinProduits;

    /**
     * Seuil de tolérance avant réapprovisionnement
     *
     * Exemple: Si on souhaite avoir en général 250 produits "XB2212" On
     * déclenche un réapprov. dès qu'on en a seuil*250 ou moins
     *
     */
    private Double seuil;

    public StockSimpleStrategy(Double seuil) {
        this.qteMinProduits = new HashMap<>();
        this.initQteMinProduits();
        this.seuil = seuil;
    }

    /**
     * Définit une quantité minimum souhaitée en stock pour chaque produit
     */
    public void initQteMinProduits() {
        this.qteMinProduits.put("BOWH209", 250);
        this.qteMinProduits.put("BOEA682", 100);
        this.qteMinProduits.put("BOMI927", 150);
        this.qteMinProduits.put("BOSN508", 50);
        this.qteMinProduits.put("BOVI359", 450);
    }

    @Override
    public void analyse(Stock s) {
        int qteManquante;
        try {
            System.out.println("[INTENRE] Analyse des stocks en cours ...");
            s.aCommander.clear();
            // Pour chaque quantité minimale par produit
            for (Map.Entry<String, Integer> qteMinProduit : this.qteMinProduits.entrySet()) {
                Produit produit = Produit.getByReference(qteMinProduit.getKey());
                // On utilise la stratégie (définie en début de classe)
                if (produit.getStock() < (qteMinProduit.getValue() * this.seuil)) {
                    qteManquante = (int) ((qteMinProduit.getValue() * 1.20) - produit.getStock());
                    s.aCommander.put((long)produit.getIdProduit(), qteManquante);
                }
            }
            System.out.println("[INTENRE] Analyse des stocks en cours terminée");
        } catch (SQLException ex) {
            Logger.getLogger(SupermarcheBehavior.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
