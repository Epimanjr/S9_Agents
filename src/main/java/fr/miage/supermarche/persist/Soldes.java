package fr.miage.supermarche.persist;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Antoine NOSAL
 */
public class Soldes {

    private static final String TABLE_NAME = "solde";
    
    private int idSolde;
    private String dateDebut;
    private String dateFin;
    private int annee;
    private int nbJours;

    public Soldes(String dateDebut, String dateFin, int annee, int nbJours) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.annee = annee;
        this.nbJours = nbJours;
    }

    public Soldes(int idSolde, String dateDebut, String dateFin, int annee, int nbJours) {
        this.idSolde = idSolde;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.annee = annee;
        this.nbJours = nbJours;
    }

    public void insert() throws SQLException {
        String sql = "INSERT INTO solde(dateDebut, dateFin, annee, nbJours) VALUES("
                +"'"+ dateDebut + "'"
                +",'" + dateFin + "'"
                +","+annee
                +","+nbJours
                +")";
        
        Connector.insert(sql);
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.idSolde;
        hash = 23 * hash + Objects.hashCode(this.dateDebut);
        hash = 23 * hash + Objects.hashCode(this.dateFin);
        hash = 23 * hash + this.annee;
        hash = 23 * hash + this.nbJours;
        return hash;
    }

    /*public ArrayList<Soldes> getAllSoldes() throws SQLException {
    String sql = "SELECT * FROM " + TABLE_NAME;
    ResultSet results = Connector.select(sql);
    ArrayList<Soldes> lsoldes = new ArrayList<>();
    while (results.next()) {
    // Récupération des informations de la BDD
    int idSolde = results.getInt("idSolde");
    String dateDebut = results.getString("dateDebut");
    String dateFin = results.getString("dateFin");
    String statut = results.getString("statut");
    Soldes soldes = new Soldes(idSolde, dateDebut, dateFin, statut);
    lsoldes.add(soldes);
    }
    return lsoldes;
    }*/
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
        final Soldes other = (Soldes) obj;
        if (this.idSolde != other.idSolde) {
            return false;
        }
        if (this.annee != other.annee) {
            return false;
        }
        if (this.nbJours != other.nbJours) {
            return false;
        }
        if (!Objects.equals(this.dateDebut, other.dateDebut)) {
            return false;
        }
        if (!Objects.equals(this.dateFin, other.dateFin)) {
            return false;
        }
        return true;
    }

    public int getIdSolde() {
        return idSolde;
    }

    public void setIdSolde(int idSolde) {
        this.idSolde = idSolde;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getNbJours() {
        return nbJours;
    }

    public void setNbJours(int nbJours) {
        this.nbJours = nbJours;
    }

    @Override
    public String toString() {
        return "Soldes{" + "idSolde=" + idSolde + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", annee=" + annee + ", nbJours=" + nbJours + '}';
    }
    
    
}
