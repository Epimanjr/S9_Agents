package fr.miage.supermarche.util.strategy;

import fr.miage.supermarche.persist.Produit;
import fr.miage.supermarche.util.Tarification;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Définit une stratégie simple de tarification Basiquement, on définit une
 * marge par catégorie
 *
 * @author Antoine NOSAL
 * @author Maxime BLAISE
 * @author Guillaume DÉNISSE
 * @author Geoffrey GAILLARD
 */
public class TarificationALaDemandeStrategy implements TarificationStrategy {

    /**
     * Estimation des marges fournisseurs sur prix producteur par catégorie
     *
     * Exemple : (1, 1.30f) => On estime que les fournisseurs multiplie par 1.30
     * le prix producteur des produits de la catégorie 1 pour faire leur prix de
     * vente
     *
     * @param p
     */
    private Map<Integer, Float> mgFourniSurProd;

    /**
     * Marges définies sur prix fournisseur par catégorie
     *
     * Exemple : (2, 1.50f) => On multiplie par 1.50 les prix d'achat pour
     * obtenir nos prix du vente sur les produits de la catégorie 2
     *
     */
    private Map<Integer, Float> mgSupermarcheSurFourni;

    public TarificationALaDemandeStrategy() {
        this.mgFourniSurProd = new HashMap<>();
        this.initMgFourniSurProd();
        this.mgSupermarcheSurFourni = new HashMap<>();
        this.initMgSupermarcheFourni();
    }

    private void initMgFourniSurProd() {
        this.mgFourniSurProd.put(1, 1.30f);
        this.mgFourniSurProd.put(2, 1.30f);
        this.mgFourniSurProd.put(3, 1.30f);
        this.mgFourniSurProd.put(4, 1.30f);
        this.mgFourniSurProd.put(5, 1.30f);
        this.mgFourniSurProd.put(6, 1.30f);
    }

    private void initMgSupermarcheFourni() {
        this.mgSupermarcheSurFourni.put(1, 1.50f);
        this.mgSupermarcheSurFourni.put(2, 1.50f);
        this.mgSupermarcheSurFourni.put(3, 1.50f);
        this.mgSupermarcheSurFourni.put(4, 1.50f);
        this.mgSupermarcheSurFourni.put(5, 1.50f);
        this.mgSupermarcheSurFourni.put(6, 1.50f);
    }

    @Override
    public void update(Tarification p, List<Produit> produits) {
        Float prixAchat;
        Float prixProducteur;
        Float prixVente;
        Integer idCategorie;
        Integer qteStock;

        try {
            System.out.println("[INTERNE] Tarification en cours ...");
            //List<Produit> produits = Produit.getAllProduit();
            for (Produit produit : produits) {
                idCategorie = produit.getIdCategorie();
                prixAchat = produit.getPrixAchat();
                prixVente = produit.getPrix();
                qteStock = produit.getStock();

                if (prixVente == -1.0f) {
                    // Si le prix de vente n'a jamais été déterminé
                    if (prixAchat != (-1.0f)) {
                        // Si on a déjà une fois acheté ce produit
                        prixVente = prixAchat * this.mgSupermarcheSurFourni.get(idCategorie);
                    } else {
                        prixProducteur = produit.getPrixProduit();
                        prixVente = prixProducteur * this.mgFourniSurProd.get(idCategorie) * this.mgSupermarcheSurFourni.get(idCategorie);
                    }
                } else if (qteStock > 0) {
                    // Si le prix a déjà été déterminé
                    int qteEnStock = qteStock;
                    prixVente = (prixAchat / ((float) (Math.log10((double) (qteEnStock))))) + prixAchat;
                    switch (p.getPeriodeType()) {
                        case STANDARD:
                            // Rien à faire
                            break;
                        case SOLDES_FETES:
                            prixVente = 0.90f * prixVente;
                            break;
                        case SOLDES_FLOTTANTES:
                            prixVente = 1.10f * prixAchat;
                            break;
                        default:
                            break;
                    }
                }

                produit.setPrix(prixVente);
                produit.update();
            }
            System.out.println("[INTERNE] Tarification terminée");
        } catch (SQLException ex) {
            Logger.getLogger(TarificationALaDemandeStrategy.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
