package fr.miage.supermarche.persist;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

/**
 *
 * @author Maxime BLAISE
 */
public class Produit {

    private static final String TABLE_NAME = "produit";
    private static final String[] FIELDS = {"reference", "nom", "description", "marque", "type", "prix", "stock"};


    /**
     * Référence numérique ( ¿clé primaire? )
     */
    private int id;

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

    private  Produit(ResultSet rs) throws SQLException {
        id = rs.getInt("id");
        reference = rs.getString("reference");
        nom = rs.getString("nom");
        description = rs.getString("description");
        marque = rs.getString("marque");
        type = rs.getString("type");
        prix = rs.getDouble("prix");
        stock = rs.getInt("stock");
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


    private static ArrayList<Produit> fetchWithQuery(String query) throws SQLException{
        ResultSet results = Connector.select(query);
        ArrayList<Produit> produits = new ArrayList<>();
        while (results.next()) {
            // Récupération des informations de la BDD
            Produit p = new Produit(results);
            produits.add(p);
        }
        return produits;
    }

    public static Optional<Produit> getById(Long id) {
        final String q = "SELECT * FROM " + TABLE_NAME + "WHERE id = " + id  + ";";
        try {
            Produit p = fetchWithQuery(q).get(0);
            return  Optional.of(p);
        } catch (SQLException | ArrayIndexOutOfBoundsException e) {
            return Optional.empty();
        }
    }

    public static Produit getByReference(String ref) throws SQLException {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE reference = '" + ref + "'";
        return fetchWithQuery(sql).get(0);
    }
    
    public static ArrayList<Produit> getAllProduit() throws SQLException {
        String sql = "SELECT * FROM " + TABLE_NAME;
        return fetchWithQuery(sql);
    }
    
    public static ArrayList<Produit> getAllProduitByCriteres(String criteres) throws SQLException {
        // TODO Parser
        String sql = "SELECT * FROM " + TABLE_NAME;
        return fetchWithQuery(sql);
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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


    public fr.miage.agents.api.model.Produit toApiProduit(){
        fr.miage.agents.api.model.Produit evilProd = new fr.miage.agents.api.model.Produit();
        evilProd.idProduit = this.id;
        //public Categorie idCategorie; TODO
        evilProd.nomProduit = this.nom;
        evilProd.descriptionProduit = this.description;
        evilProd.prixProduit = (float) this.prix;
        evilProd.marque = this.marque;
        return evilProd;
    }

    @Override
    public String toString() {
        return "Produit{" + "reference=" + reference + ", nom=" + nom + ", description=" + description + ", marque=" + marque + ", type=" + type + ", prix=" + prix + ", stock=" + stock + '}';
    }

}
