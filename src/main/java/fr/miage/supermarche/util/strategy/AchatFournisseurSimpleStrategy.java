package fr.miage.supermarche.util.strategy;

import fr.miage.supermarche.persist.Produit;
import fr.miage.supermarche.util.AchatFournisseur;
import java.sql.SQLException;
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
