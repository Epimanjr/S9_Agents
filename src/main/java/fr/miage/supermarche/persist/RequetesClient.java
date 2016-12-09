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

    /**
     * Permet de récupérer les produits en fonction de critères.
     *
     * @param nom Nom du produit.
     * @param categorie Catégorie du produit (type dans la base).
     * @param marque Marque du produit
     * @param prixMin Prix minimal du produit recherché
     * @param prixMax Prix maximal du produit recherché
     * @return Liste d'identifiants de produits
     * @throws SQLException Si erreur de connexion à la base.
     */
    public static List<Integer> getIdWithCriteres(String nom, String categorie, String marque, int prixMin, int prixMax) throws SQLException {
        List<Integer> produits = new ArrayList<>();
        ResultSet results = Connector.select("SELECT id, nom, description, marque, prix FROM produit");
        while (results.next()) {
            // TODO ajouter produit à la liste si compatible

            // Vérifier le prix
            double prixProduit = results.getDouble("prix");
            boolean flagPrix = (prixProduit >= prixMin) && (prixProduit <= prixMax);
            if (flagPrix) {
                // Savoir si le produit a été ajouté la liste ou non
                boolean flag = false;

                if (!nom.equals("")) {
                    String nomProduit = results.getString("nom");
                    if (nom.equalsIgnoreCase(nomProduit)) {
                        int id = results.getInt("id");
                        produits.add(id);
                        flag = true;
                    }
                }

                if (!flag && !categorie.equals("")) {
                    String categorieProduit = results.getString("type");
                    if (categorie.equalsIgnoreCase(categorieProduit)) {
                        int id = results.getInt("id");
                        produits.add(id);
                        flag = true;
                    }
                }

                if (!flag && !marque.equals("")) {
                    String marqueProduit = results.getString("marque");
                    if (marque.equalsIgnoreCase(marqueProduit)) {
                        int id = results.getInt("id");
                        produits.add(id);
                    }
                }
            }
        }
        return produits;
    }

    /**
     * Permet de récupérer les produits en fonction de critères.
     *
     * @param criteres Critères souhaités
     * @return Liste d'identifiants de produits
     * @throws SQLException Si erreur de connexion à la base.
     */
    public static List<Integer> getIdWithCriteres(String criteres) throws SQLException {
        double seuil = 30.0;

        List<Integer> produits = new ArrayList<>();
        ResultSet results = Connector.select("SELECT id, nom, description, marque FROM produit");
        while (results.next()) {
            List<String> mots = new ArrayList<>();
            String[] tab1 = results.getString("nom").split(" ");
            String[] tab2 = results.getString("description").split(" ");
            String[] tab3 = results.getString("marque").split(" ");

            for (String s : tab1) {
                mots.add(s.toLowerCase());
            }
            for (String s : tab2) {
                mots.add(s.toLowerCase());
            }
            for (String s : tab3) {
                mots.add(s.toLowerCase());
            }

            int nbOccurences = 0;
            String[] criteresTab = criteres.toLowerCase().split(" ");
            for (String mot : criteresTab) {
                if (mots.contains(mot)) {
                    nbOccurences++;
                }
            }

            double nb = nbOccurences * 100 / criteresTab.length;
            if (nb > seuil) {
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
