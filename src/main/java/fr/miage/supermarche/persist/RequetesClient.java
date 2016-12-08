package fr.miage.supermarche.persist;

import fr.miage.supermarche.exception.ProduitNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Contient toutes les méthodes nécessaires pour répondre au besoin du client.
 *
 * @author Maxime BLAISE
 */
public class RequetesClient {

    
    public static List<Integer> getIdWithCriteres(String criteres) throws SQLException {
        // TODO 
        
        return null;
    }
    
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
    
    /**
     * Permet de récupérer un prix d'un produit à partir de son ID.
     *
     * @param id Identifiant du produit.
     * @return Prix du produit.
     * @throws SQLException Si erreur de connexion à la base.
     * @throws ProduitNotFoundException Si produit non trouvé.
     */
    public static double getPrixWithRef(Integer id) throws SQLException, ProduitNotFoundException {
        double prix = 0.0;

        // Query
        ResultSet result = Connector.select("SELECT prix FROM produit WHERE id='" + id + "'");
        if (result.next()) {
            // Récupération du prix
            prix = result.getDouble("prix");
        } else {
            throw new ProduitNotFoundException();
        }

        return prix;
    }
}
