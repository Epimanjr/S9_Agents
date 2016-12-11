package fr.miage.supermarche.util.strategy;

import fr.miage.supermarche.persist.Produit;
import fr.miage.supermarche.util.AchatFournisseur;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Définit une stratégie d'achat simple basée sur le produit, son prix, la
 * quantité souhaitée et la quantité disponible en stock
 *
 * @author Antoine NOSAL
 * @author Maxime BLAISE
 * @author Guillaume DÉNISSE
 * @author Geoffrey GAILLARD
 */
public class AchatFournisseurSimpleStrategy implements AchatFournisseurStrategy {

    /**
     * Pourcentage maximal du prix de vente auquel on est d'accord d'acheter le
     * produit chez le fournisseur idCategorie -> seuil Par exemple : (6, 0.70)
     * <=> On n'achète pas un produit de la catégorie 6 au dessus du 70% du prix
     * de vente que l'on a défini
     */
    private Map<Integer, Float> partFournisseurProduits;

    /**
     * Initialise les parts fournisseurs pour chaque catégorie de produits
     */
    private void initPartFournisseurProduits() {
        this.partFournisseurProduits.put(1, 0.80f);
        this.partFournisseurProduits.put(2, 0.80f);
        this.partFournisseurProduits.put(3, 0.80f);
        this.partFournisseurProduits.put(4, 0.80f);
        this.partFournisseurProduits.put(5, 0.80f);
        this.partFournisseurProduits.put(6, 0.80f);
    }

    public AchatFournisseurSimpleStrategy() {
        this.partFournisseurProduits = new HashMap<>();
        this.initPartFournisseurProduits();
    }

    /**
     * En fonction du produit (af.getIdProduit) et du prix (af.getPrix), de la
     * quantité souhaitée (..) et de la quantité disponible (..) chez le
     * fournisseur la stratégie nous dit si on achète ou non
     *
     * @param af Achat proposé à valider/refuser
     * @return boolean true si on peut acheter
     */
    @Override
    public boolean approuver(AchatFournisseur af) {
        System.out.println("[FOURNISSEUR] Etude d'un achat en cours ...");
        Optional<Produit> oProduit = Produit.getById(af.getIdProduit());
        if (oProduit.isPresent()) {
            Produit produit = oProduit.get();
            
            Float prixPropose = af.getPrixProposeParFournisseur();
            Integer qteSouhaitee = af.getQteSouhaitee();
            Integer qteDisponible = af.getQteDisponibleChezFournisseur();
            
            System.out.println("produit: "+produit.getIdProduit());
            System.out.println("qteSouhaitee: "+qteSouhaitee);
            System.out.println("qteDispo:"+qteDisponible);
            
            if (qteDisponible >= qteSouhaitee) {
                // Si la quantité disponible est suffisante, on s'intéresse au prix proposé
                
                Float seuil = this.partFournisseurProduits.get(produit.getIdCategorie());
                Float prixVente = produit.getPrix();
                Float prixMax = (seuil * prixVente);
                
                if (prixPropose <= prixMax) {
                    // Si le prix ne dépasse pas notre seuil, on approuve
                    System.out.println("[FOURNISSEUR] Etude d'un achat terminée ... oui");
                    return true;
                } else {
                    // Si le prix est trop élevé, on propose un prix plus bas
                    /**
                     * Exemple : Si : il propose 100 alors que notre prix
                     * max est de 80 Alors : on lui propose [80-(100-80)]
                     * soit 60
                     */
                    af.setPrixANegocier(prixMax - (prixPropose - prixMax));
                    System.out.println("[FOURNISSEUR] Etude d'un achat terminée ... non");
                    return false;
                }
            }
        }
        // Si le fournisseur n'a pas la quantité suffisante,
        // On l'indique en mettant le prix à négocier à (-1)
        af.setPrixANegocier(-1);
        System.out.println("[FOURNISSEUR] Etude d'un achat terminée ... non");
        return false;
    }

}
