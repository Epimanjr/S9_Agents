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

    private static final String TABLE_NAME = "soldes";
    private static final String[] FIELDS = {"idSolde", "dateDebut", "dateFin", "statut"};
    
    private int idSolde;
    private String dateDebut;
    private String dateFin;
    private String statut;

    public Soldes(int idSolde, String dateDebut, String dateFin, String statut) {
        this.idSolde = idSolde;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.statut = statut;
    }

    public ArrayList<Soldes> getAllSoldes() throws SQLException {
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
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + this.idSolde;
        hash = 31 * hash + Objects.hashCode(this.dateDebut);
        hash = 31 * hash + Objects.hashCode(this.dateFin);
        hash = 31 * hash + Objects.hashCode(this.statut);
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
        final Soldes other = (Soldes) obj;
        if (this.idSolde != other.idSolde) {
            return false;
        }
        if (!Objects.equals(this.dateDebut, other.dateDebut)) {
            return false;
        }
        if (!Objects.equals(this.dateFin, other.dateFin)) {
            return false;
        }
        if (!Objects.equals(this.statut, other.statut)) {
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

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
    
}
