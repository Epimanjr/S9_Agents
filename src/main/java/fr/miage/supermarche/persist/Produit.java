package fr.miage.supermarche.persist;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Maxime BLAISE
 */
public class Produit {

    private static final String TABLE_NAME = "produit";
    private static final String[] FIELDS = {"reference", "nom", "description", "marque", "type", "prix", "stock"};

    /**
     * Référence du produit (clé primaire)
     */
    private String reference;

    /**
     * Nom du produit.
     */
    private String nom;

    /**
     * Description du produit.
     */
    private String description;

    /**
     * Marque du produit.
     */
    private String marque;

    /**
     * Type du produit.
     */
    private String type;

    /**
     * Prix du produit.
     */
    private double prix;

    /**
     * Nombre de ce produit en stock.
     */
    private int stock;

    public Produit() {
    }

    public Produit(String reference, String nom, String description, String marque, String type, double prix, int stock) {
        this.reference = reference;
        this.nom = nom;
        this.description = description;
        this.marque = marque;
        this.type = type;
        this.prix = prix;
        this.stock = stock;
    }

    public static ArrayList<Produit> getAllProduit() throws SQLException {
        String sql = "SELECT * FROM " + TABLE_NAME;
        ResultSet results = Connector.select(sql);

        ArrayList<Produit> produits = new ArrayList<>();
        while (results.next()) {
            // Récupération des informations de la BDD
            String reference = results.getString("reference");
            String nom = results.getString("nom");
            String description = results.getString("description");
            String marque = results.getString("marque");
            String type = results.getString("type");
            Double prix = results.getDouble("prix");
            Integer stock = results.getInt("stock");

            Produit produit = new Produit(reference, nom, description, marque, type, prix, stock);
            produits.add(produit);
        }

        return produits;
    }
    
    public static ArrayList<Produit> getAllProduitByCriteres(String criteres) throws SQLException {
        // TODO Parser
        String sql = "SELECT * FROM " + TABLE_NAME;
        
        ResultSet results = Connector.select(sql);

        ArrayList<Produit> produits = new ArrayList<>();
        while (results.next()) {
            // Récupération des informations de la BDD
            String reference = results.getString("reference");
            String nom = results.getString("nom");
            String description = results.getString("description");
            String marque = results.getString("marque");
            String type = results.getString("type");
            Double prix = results.getDouble("prix");
            Integer stock = results.getInt("stock");

            Produit produit = new Produit(reference, nom, description, marque, type, prix, stock);
            produits.add(produit);
        }

        return produits;
    }

    public void insert() throws SQLException {
        String sql = "INSERT INTO " + TABLE_NAME + "(" + FIELDS[0];
        for (int i = 1; i < FIELDS.length; i++) {
            sql += ", " + FIELDS[i];
        }
        sql += ") VALUES("
                + "'" + this.reference + "'"
                + ", '" + this.nom + "'"
                + ", '" + this.description + "'"
                + ", '" + this.marque + "'"
                + ", '" + this.type + "'"
                + ", " + this.prix
                + ", " + this.stock
                + ")";

        Connector.insert(sql);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.reference);
        hash = 29 * hash + Objects.hashCode(this.nom);
        hash = 29 * hash + Objects.hashCode(this.description);
        hash = 29 * hash + Objects.hashCode(this.marque);
        hash = 29 * hash + Objects.hashCode(this.type);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.prix) ^ (Double.doubleToLongBits(this.prix) >>> 32));
        hash = 29 * hash + this.stock;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produit other = (Produit) obj;
        if (Double.doubleToLongBits(this.prix) != Double.doubleToLongBits(other.prix)) {
            return false;
        }
        if (this.stock != other.stock) {
            return false;
        }
        if (!Objects.equals(this.reference, other.reference)) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.marque, other.marque)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        return true;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Produit{" + "reference=" + reference + ", nom=" + nom + ", description=" + description + ", marque=" + marque + ", type=" + type + ", prix=" + prix + ", stock=" + stock + '}';
    }

}
