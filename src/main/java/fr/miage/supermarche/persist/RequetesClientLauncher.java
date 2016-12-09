package fr.miage.supermarche.persist;

import fr.miage.supermarche.exception.ProduitNotFoundException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Permet de tester les requêtes clients
 */
public class RequetesClientLauncher {

    public static void testGetPrixByRef() {
        try {
            double prix = RequetesClient.getPrixWithRef("BOBI16");
            System.out.println(prix);
            double prix2 = RequetesClient.getPrixWithRef(1964520057);
            System.out.println(prix2);
        } catch (SQLException ex) {
            Logger.getLogger(RequetesClientLauncher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProduitNotFoundException ex) {
            Logger.getLogger(RequetesClientLauncher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void testGetIdByCriteres() {
        try {
            List<Integer> produits = RequetesClient.getIdWithCriteres("bière", "", "", 0, 1000);
            for (int produit : produits) {
                System.out.println(produit);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RequetesClientLauncher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        // testGetIdByCriteres();
        testGetPrixByRef();
    }
}
