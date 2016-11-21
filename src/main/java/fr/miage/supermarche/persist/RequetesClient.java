package fr.miage.supermarche.persist;

import fr.miage.supermarche.exception.ProduitNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Contient toutes les méthodes nécessaires pour répondre au besoin du client.
 *
 * @author Maxime BLAISE
 */
public class RequetesClient {

    /**
     * Permet de récupérer un prix d'un produit à partir de sa référence.
     *
     * @param ref Référénce du produit.
     * @return Prix du produit.
     * @throws SQLException Si erreur de connexion à la base.
     * @throws ProduitNotFoundException Si produit non trouvé.
     */
    public static double getPrixWithRef(String ref) throws SQLException, ProduitNotFoundException {
        double prix = 0.0;

        // Query
        ResultSet result = Connector.select("SELECT prix FROM produit WHERE reference='" + ref + "'");
        if (result.next()) {
            // Récupération du prix
            prix = result.getDouble("prix");
        } else {
            throw new ProduitNotFoundException();
        }

        return prix;
    }
}
