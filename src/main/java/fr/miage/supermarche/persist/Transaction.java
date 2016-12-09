package fr.miage.supermarche.persist;

import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Transaction {

    /**
     * Identifiant unique de la transaction.
     */
    private int id;

    /**
     * Type de la transaction.
     */
    private TypeTransaction type;

    /**
     * Produit concerné.
     */
    private int idProduit;

    /**
     * Qté de produits achetée/vendue
     */
    private int qteProduit;

    /**
     * Montant total de la transaction.
     */
    private float montantTotal;

    /**
     * Pour connaître la date de la transaction.
     */
    private long timestamp;

    public Transaction(int id, TypeTransaction type, int idProduit, int qteProduit, float montantTotal, long timestamp) {
        this.id = id;
        this.type = type;
        this.idProduit = idProduit;
        this.qteProduit = qteProduit;
        this.montantTotal = montantTotal;
        this.timestamp = timestamp;
    }

    public Transaction(TypeTransaction type, int idProduit, int qteProduit, float montantTotal) {
        this.type = type;
        this.idProduit = idProduit;
        this.qteProduit = qteProduit;
        this.montantTotal = montantTotal;
        this.timestamp = getCurrentTimestamp();
    }

    public Transaction(TypeTransaction type, int idProduit, int qteProduit, float montantTotal, long timestamp) {
        this.type = type;
        this.idProduit = idProduit;
        this.qteProduit = qteProduit;
        this.montantTotal = montantTotal;
        this.timestamp = timestamp;
    }

    /**
     * Récupère le timestamp correspondant à la date actuelle.
     *
     * @return Long
     */
    public static long getCurrentTimestamp() {
        GregorianCalendar calendar = new GregorianCalendar();
        return calendar.getTimeInMillis();
    }

    /**
     * Permet d'insérer la transaction dans la base.
     *
     * @throws SQLException Si erreur de connection à la base
     */
    public void insert() throws SQLException {
        String sql = "INSERT INTO transaction(type, idProduit, qteProduit, montantTotal, timestamp) VALUES ("
                + "'" + this.type.getType() + "'"
                + ", " + this.idProduit
                + ", " + this.qteProduit
                + ", " + this.montantTotal
                + ", " + this.timestamp
                + ")";
        Connector.insert(sql);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TypeTransaction getType() {
        return type;
    }

    public void setType(TypeTransaction type) {
        this.type = type;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public int getQteProduit() {
        return qteProduit;
    }

    public void setQteProduit(int qteProduit) {
        this.qteProduit = qteProduit;
    }

    public float getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(float montantTotal) {
        this.montantTotal = montantTotal;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    
    public static void main(String[] args) {
        Transaction trans = new Transaction(TypeTransaction.VENTE, 1, 2, 10.0f);
        try {
            trans.insert();
        } catch (SQLException ex) {
            Logger.getLogger(Transaction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
