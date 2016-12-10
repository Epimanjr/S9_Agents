package fr.miage.supermarche.persist;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maxime BLAISE
 */
public class ImportHelper {

    /*public void run() {
        InputStream input = null;

        try {

            File file = new File("C:\\Users\\maxim\\Documents\\Projets\\S9_Agents\\src\\main\\resources\\bdd\\Produits.csv");

            System.out.println(file.getAbsolutePath());

            BufferedReader br = new BufferedReader(new FileReader(file));
            while (br.ready()) {
                String line = br.readLine();

                String[] lineSplit = line.split(";");
                String nomProduit = lineSplit[0];
                String marqueProduit = lineSplit[1];
                String descriptionProduit = lineSplit[2].replaceAll("'", "''");
                Double prixProduit = Double.parseDouble(lineSplit[3]);
                String categorieProduit = lineSplit[4];

                int alea = (int) (Math.random() * 1000);
                String ref = categorieProduit.substring(0, 2) + nomProduit.substring(0, 2) + alea;
                String reference = ref.toUpperCase();
                Produit p = new Produit(reference, nomProduit, descriptionProduit, marqueProduit, categorieProduit, prixProduit, 0);
                try {
                    p.insert();
                } catch (SQLException ex) {
                    System.out.println("Impossible d'insérer : " + p);
                }
            }
            br.close();

        } catch (IOException ex) {
            // ex.printStackTrace();
            System.out.println("Erreur de lecture du fichier Produits.csv");
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }*/

    public static void setIdToRef() {
        try {
            ResultSet results = Connector.getConnector().select("SELECT reference FROM produit");
            while (results.next()) {
                String ref = results.getString("reference");
                int id = ref.hashCode();

                String sql = "UPDATE produit SET id=" + id + " WHERE reference='" + ref + "'";
                Connector.getConnector().insert(sql);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImportHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void setRefToId() {
        try {
            ResultSet results = Connector.select("SELECT idProduit, nomCategorie, nomProduit FROM produit NATURAL JOIN categorie");
            while(results.next()) {
                int idProduit = results.getInt("idProduit");
                String nomCategorie = results.getString("nomCategorie");
                String nomProduit = results.getString("nomProduit");
                
                int alea = (int)(Math.random() * 1000);
                String ref = nomCategorie.substring(0, 2).toUpperCase()
                        + nomProduit.substring(0, 2).toUpperCase()
                        + alea;
                
                String sql = "UPDATE produit SET refProduit='" + ref + "' WHERE idProduit="+idProduit;
                Connector.insert(sql);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImportHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public static void main(String[] args) {
        /*ImportHelper ih = new ImportHelper();
        ih.run();*/
        // setIdToRef();
        setRefToId();
    }
}
