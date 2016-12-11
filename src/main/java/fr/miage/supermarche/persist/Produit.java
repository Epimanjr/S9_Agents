package fr.miage.supermarche.persist;

import fr.miage.supermarche.util.ApiProduit;

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
    private static final String[] FIELDS = {"nomProduit", "marqueProduit", "descriptionProduit", "prixProduit", "prix", "prixAchat", "stock", "idCategorie"};

    /**
     * Référence numérique ( ¿clé primaire? )
     */
    private int idProduit;

    /**
     * Nom du produit.
     */
    private String nomProduit;

    /**
     * Référence produit (généré).
     */
    private String refProduit;

    /**
     * Description du produit.
     */
    private String descriptionProduit;

    /**
     * Marque du produit.
     */
    private String marqueProduit;

    /**
     * Categorie du produit.
     */
    private String categorie;

    private int idCategorie;

    /**
     * Prix du produit (de vente, supermarché).
     */
    private float prix = -1f;

    /**
     * Prix du produit (producteur).
     */
    private float prixProduit;

    /**
     * Prix du produit (fournisseur).
     */
    private float prixAchat = -1f;

    /**
     * Nombre de ce produit en stock.
     */
    private int stock = 0;

    public Produit() {
    }

    private Produit(ResultSet rs) throws SQLException {
        idProduit = rs.getInt("idProduit");
        refProduit = rs.getString("refProduit");
        nomProduit = rs.getString("nomProduit");
        marqueProduit = rs.getString("marqueProduit");
        descriptionProduit = rs.getString("descriptionProduit");
        prix = rs.getFloat("prix");
        prixProduit = rs.getFloat("prixProduit");
        prixAchat = rs.getFloat("prixAchat");
        stock = rs.getInt("stock");
        idCategorie = rs.getInt("idCategorie");
    }

    public Produit(String reference, String nom, String description, String marque, String type, float prix, int stock) {
        this.nomProduit = nom;
        this.descriptionProduit = description;
        this.marqueProduit = marque;
        this.categorie = type;
        this.prix = prix;
        this.stock = stock;
    }

    private static ArrayList<Produit> fetchWithQuery(String query) throws SQLException {
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
        final String q = "SELECT * FROM " + TABLE_NAME + " WHERE idProduit = " + id + ";";
        System.out.println(q);
        try {
            Produit p = fetchWithQuery(q).get(0);
            return Optional.of(p);
        } catch (SQLException | ArrayIndexOutOfBoundsException e) {
            return Optional.empty();
        }
    }

    public static Produit getByReference(String ref) throws SQLException {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE refProduit = '" + ref + "'";
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
                + "'" + this.nomProduit + "'"
                + ", '" + this.marqueProduit + "'"
                + ", '" + this.descriptionProduit + "'"
                + ", " + this.prixProduit
                + ", " + this.prix
                + ", " + this.prixAchat
                + ", " + this.stock
                + ", " + this.idCategorie
                + ")";

        Connector.insert(sql);
    }

    /**
     * Mise à jour du produit dans la base.
     *
     * @throws SQLException .
     */
    public void update() throws SQLException {
        String sql = "UPDATE produit "
                + "SET nomProduit='" + this.nomProduit.replaceAll("'", "") + "'"
                + ", marqueProduit='" + this.marqueProduit.replaceAll("'", "") + "'"
                + ", descriptionProduit='" + this.descriptionProduit.replaceAll("'", "") + "'"
                + ", prixProduit=" + this.prixProduit
                + ", prixAchat=" + this.prixAchat
                + ", prix=" + this.prix
                + ", stock=" + this.stock
                + ", idCategorie=" + this.idCategorie
                + " WHERE idProduit=" + this.idProduit;

        Connector.insert(sql);
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public String getDescriptionProduit() {
        return descriptionProduit;
    }

    public void setDescriptionProduit(String descriptionProduit) {
        this.descriptionProduit = descriptionProduit;
    }

    public String getMarqueProduit() {
        return marqueProduit;
    }

    public void setMarqueProduit(String marqueProduit) {
        this.marqueProduit = marqueProduit;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public float getPrixProduit() {
        return prixProduit;
    }

    public void setPrixProduit(float prixProduit) {
        this.prixProduit = prixProduit;
    }

    public float getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(float prixAchat) {
        this.prixAchat = prixAchat;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getRefProduit() {
        return refProduit;
    }

    public void setRefProduit(String refProduit) {
        this.refProduit = refProduit;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.idProduit;
        hash = 29 * hash + Objects.hashCode(this.nomProduit);
        hash = 29 * hash + Objects.hashCode(this.descriptionProduit);
        hash = 29 * hash + Objects.hashCode(this.marqueProduit);
        hash = 29 * hash + Objects.hashCode(this.categorie);
        hash = 29 * hash + this.idCategorie;
        hash = 29 * hash + Float.floatToIntBits(this.prix);
        hash = 29 * hash + Float.floatToIntBits(this.prixProduit);
        hash = 29 * hash + Float.floatToIntBits(this.prixAchat);
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
        if (this.idProduit != other.idProduit) {
            return false;
        }
        if (this.idCategorie != other.idCategorie) {
            return false;
        }
        if (Float.floatToIntBits(this.prix) != Float.floatToIntBits(other.prix)) {
            return false;
        }
        if (Float.floatToIntBits(this.prixProduit) != Float.floatToIntBits(other.prixProduit)) {
            return false;
        }
        if (Float.floatToIntBits(this.prixAchat) != Float.floatToIntBits(other.prixAchat)) {
            return false;
        }
        if (this.stock != other.stock) {
            return false;
        }
        if (!Objects.equals(this.nomProduit, other.nomProduit)) {
            return false;
        }
        if (!Objects.equals(this.descriptionProduit, other.descriptionProduit)) {
            return false;
        }
        if (!Objects.equals(this.marqueProduit, other.marqueProduit)) {
            return false;
        }
        if (!Objects.equals(this.categorie, other.categorie)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produit{" + "idProduit=" + idProduit + ", nomProduit=" + nomProduit + ", descriptionProduit=" + descriptionProduit + ", marqueProduit=" + marqueProduit + ", categorie=" + categorie + ", idCategorie=" + idCategorie + ", prix=" + prix + ", prixProduit=" + prixProduit + ", prixAchat=" + prixAchat + ", stock=" + stock + '}';
    }

    public ApiProduit toApiProduit() {
        ApiProduit evilProd = new ApiProduit();
        evilProd.idProduit = this.idProduit;
        //public Categorie idCategorie; TODO
        evilProd.nomProduit = this.nomProduit;
        evilProd.descriptionProduit = this.descriptionProduit;
        evilProd.prixProduit = (float) this.prix;
        evilProd.marque = this.marqueProduit;
        return evilProd;
    }

}
