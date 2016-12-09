package fr.miage.supermarche.persist;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;

public class RequetesInternes {

    /**
     * Permet de retirer des produits du stock de notre base. Par exemple après
     * un achat d'un client.
     *
     * @param mapProduits Produits que l'on retire avec la quantité associée
     * @return Map pour avoir le compte-rendu des produits retirés
     */
    public static HashMap<Integer, Boolean> retirerProduits(HashMap<Integer, Integer> mapProduits) {
        HashMap<Integer, Boolean> mapResults = new HashMap<>();

        // Parcours des produits de la map 
        Iterator<Integer> itProduits = mapProduits.keySet().iterator();
        while (itProduits.hasNext()) {
            Integer idProduit = itProduits.next();
            Integer qteProduit = mapProduits.get(idProduit);

            String sql = "SELECT stock FROM produit WHERE id=" + idProduit;
            ResultSet result;
            try {
                result = Connector.select(sql);
                if (result.next()) {
                    Integer stockProduit = result.getInt("stock");
                    if (stockProduit >= qteProduit) {
                        Integer newStock = stockProduit - qteProduit;
                        String sqlUpdate = "UPDATE produit set stock=" + newStock + " WHERE id=" + idProduit;
                        Connector.insert(sqlUpdate);
                    } else {
                        mapResults.put(idProduit, false);
                    }
                } else {
                    // Normalement on est forcément obligé de trouver le produit... 
                    mapResults.put(idProduit, false);
                }
            } catch (SQLException ex) {
                System.err.println("Erreur: impossible de récupérer ou modifier le stock du produit " + idProduit);
                ex.printStackTrace();
            }

        }
        return mapResults;
    }
}
