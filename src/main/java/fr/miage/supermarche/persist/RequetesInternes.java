package fr.miage.supermarche.persist;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;

public class RequetesInternes {

    public static int nbJoursSoldesFlottantesRestants() {
        int nbJoursRestantes = 10;
        int annee = new GregorianCalendar().get(GregorianCalendar.YEAR);
        
        String sql = "SELECT nbJours FROM solde WHERE annee="+annee;
        try {
            ResultSet results = Connector.select(sql);
            while(results.next()) {
                int nbJours = results.getInt("nbJours");
                nbJoursRestantes -= nbJours;
            }
        } catch (SQLException ex) {
            //Logger.getLogger(RequetesInternes.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erreur: impossible d'exécuter : " + sql);
            return 0;
        }
        return (nbJoursRestantes > 0) ? nbJoursRestantes : 0;
    }
    
    /**
     * Permet de retirer des produits du stock de notre base. Par exemple après
     * un achat d'un client.
     *
     * @param mapProduits Produits que l'on retire avec la quantité associée
     * @return Map pour avoir le compte-rendu des produits retirés
     */
    public static HashMap<Long, Integer> retirerProduits(HashMap<Long, Integer> mapProduits) {
        HashMap<Long, Integer> mapResults = new HashMap<>();

        // Parcours des produits de la map 
        Iterator<Long> itProduits = mapProduits.keySet().iterator();
        while (itProduits.hasNext()) {
            Long idProduit = itProduits.next();
            Integer qteProduit = mapProduits.get(idProduit);

            mapResults.put(idProduit, retirerProduit(idProduit, qteProduit));
        }
        return mapResults;
    }

    /**
     * Permet d'ajouter des produits du stock de notre base. Par exemple après
     * un achat auprès d'un fournisseur.
     *
     * @param mapProduits Produits que l'on ajoute avec la quantité associée
     * @return Map pour avoir le compte-rendu des produits retirés
     */
    public static HashMap<Integer, Boolean> ajouterProduits(HashMap<Integer, Integer> mapProduits) {
        HashMap<Integer, Boolean> mapResults = new HashMap<>();

        // Parcours des produits de la map 
        Iterator<Integer> itProduits = mapProduits.keySet().iterator();
        while (itProduits.hasNext()) {
            Integer idProduit = itProduits.next();
            Integer qteProduit = mapProduits.get(idProduit);

            // Traitement et ajout
            mapResults.put(idProduit, ajouterProduit(idProduit, qteProduit));
        }
        return mapResults;
    }

    /**
     * Permet de retirer un seul produit dans la base
     *
     * @param idProduit Identifiant du produit
     * @param qteProduit Quantité à retirer
     * @return la quantité retirée, la valeur du stock si la quantité > au stock
     */
    public static Integer retirerProduit(Long idProduit, Integer qteProduit) {
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
                    return qteProduit;
                } else {
                    return stockProduit;
                }
            }
        } catch (SQLException ex) {
            System.err.println("Erreur: impossible de récupérer ou modifier le stock du produit " + idProduit);
            ex.printStackTrace();
        }

        return -1;
    }

    /**
     * Permet d'ajouter un seul produit dans la base
     *
     * @param idProduit Identifiant du produit
     * @param qteProduit Quantité à ajouter
     * @return Si bien ajouté
     */
    public static boolean ajouterProduit(Integer idProduit, Integer qteProduit) {
        try {
            String sql = "SELECT stock FROM produit WHERE idProduit=" + idProduit;
            ResultSet result = Connector.select(sql);
            if (result.next()) {
                Integer stockProduit = result.getInt("stock");
                Integer newStock = stockProduit + qteProduit;

                String sqlUpdate = "UPDATE produit set stock=" + newStock + " WHERE idProduit=" + idProduit;
                Connector.insert(sqlUpdate);
                return true;
            }
        } catch (SQLException ex) {
            System.err.println("Erreur: impossible de récupérer ou modifier le stock du produit " + idProduit);
            ex.printStackTrace();
        }

        return false;
    }
    
    /**
     * Permet d'ajouter un seul produit dans la base
     *
     * @param idProduit Identifiant du produit
     * @param qteProduit Quantité à ajouter
     * @return Si bien ajouté
     */
    public static boolean ajouterProduit(Integer idProduit, Integer qteProduit, float prixAchat) {
        try {
            String sql = "SELECT stock FROM produit WHERE idProduit=" + idProduit;
            ResultSet result = Connector.select(sql);
            if (result.next()) {
                Integer stockProduit = result.getInt("stock");
                Integer newStock = stockProduit + qteProduit;

                String sqlUpdate = "UPDATE produit set stock=" + newStock + " , prixAchat=" + prixAchat + " WHERE idProduit=" + idProduit;
                Connector.insert(sqlUpdate);
                return true;
            }
        } catch (SQLException ex) {
            System.err.println("Erreur: impossible de récupérer ou modifier le stock du produit " + idProduit);
            ex.printStackTrace();
        }

        return false;
    }
}
