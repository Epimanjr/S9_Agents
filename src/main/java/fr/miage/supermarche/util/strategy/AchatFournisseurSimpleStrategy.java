package fr.miage.supermarche.util.strategy;

import fr.miage.supermarche.persist.Produit;
import fr.miage.supermarche.util.AchatFournisseur;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
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
     * Pourcentage maximal du prix de vente
     * auquel on est d'accord d'acheter le produit
     * chez le fournisseur
     * idCategorie -> seuil
     * Par exemple :
     * (6, 0.70) <=> On n'achète pas un produit de la
     * catégorie 6 au dessus du 70% du prix de vente
     * que l'on a défini
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

    public AchatFournisseurSimpleStrategy(Map<Integer, Float> partFournisseurProduits) {
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
        try {
            // TODO : remplacer par la ligne suivante dès que la méthode sera dispo
            //Produit produit = Produit.getById(af.getIdProduit());
            Produit produit = Produit.getByReference("todo");
            Float prixPropose = af.getPrixProposeParFournisseur();
            Integer qteSouhaitee = af.getQteSouhaitee();
            Integer qteDisponible = af.getQteDisponibleChezFournisseur();
            
            // TODO : approuver ou non la proposition d'achat
            
            // TODO : Il faut aussi ici déterminer le prochain
            // prix que l'on va proposer pour négocier
            af.setPrixANegocier(0);
        } catch (SQLException ex) {
            Logger.getLogger(AchatFournisseurSimpleStrategy.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
