package fr.miage.supermarche.persist;

import fr.miage.supermarche.exception.ProduitNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Contient toutes les méthodes nécessaires pour répondre au besoin du client.
 *
 * @author Maxime BLAISE
 */
public class RequetesClient {

    
    public static List<Integer> getIdWithCriteres(String criteres) throws SQLException {
        // TODO
        double seuil = 30.0;
        
        List<Integer> produits = new ArrayList<>();
        ResultSet results = Connector.select("SELECT id, nom, description, marque FROM produit");
        while(results.next()) {
            List<String> mots = new ArrayList<>();
            String[] tab1 = results.getString("nom").split(" ");
            String[] tab2 = results.getString("description").split(" ");
            String[] tab3 = results.getString("marque").split(" ");
            
            for(String s: tab1) mots.add(s.toLowerCase());
            for(String s: tab2) mots.add(s.toLowerCase());
            for(String s: tab3) mots.add(s.toLowerCase());
            
            int nbOccurences = 0;
            String[] criteresTab = criteres.toLowerCase().split(" ");
            for(String mot: criteresTab) {
                if(mots.contains(mot)) nbOccurences++;
            }
            
            double nb = nbOccurences * 100 / criteresTab.length;
            if(nb > seuil) {
                produits.add(results.getInt("id"));
            }
        }
        return produits;
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
