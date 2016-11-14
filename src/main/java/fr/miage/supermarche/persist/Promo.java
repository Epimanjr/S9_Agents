package fr.miage.supermarche.persist;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Antoine NOSAL
 */
public class Promo {

    private static final String TABLE_NAME = "promo";
    private static final String[] FIELDS = {"idPromo", "listeReference", "reduction"};

    private int idPromo;
    private String listeReference;
    private int reduction;

    public Promo(int idPromo, String listeReference, int reduction) {
        this.idPromo = idPromo;
        this.listeReference = listeReference;
        this.reduction = reduction;
    }
    
    public ArrayList<Promo> getAllPromo() throws SQLException {
        String sql = "SELECT * FROM " + TABLE_NAME;
        ResultSet results = Connector.select(sql);

        ArrayList<Promo> promos = new ArrayList<>();
        while (results.next()) {
            // Récupération des informations de la BDD
            int idPromo = results.getInt("idPromo");
            String listeReference = results.getString("listeReference");
            int reduction = results.getInt("reduction");
            
            Promo promo = new Promo(idPromo, listeReference, reduction);
            promos.add(promo);
        }

        return promos;
    }
    
    public ArrayList<Promo> getPromoByReferences(ArrayList<String> listeReferences) throws SQLException {
        String sql = "SELECT * FROM " + TABLE_NAME;
        for(String ref : listeReferences) {
            sql += "";
        }
        ResultSet results = Connector.select(sql);
        
        ArrayList<Promo> promos = new ArrayList<>();
        while (results.next()) {
            // Récupération des informations de la BDD
            int idPromo = results.getInt("idPromo");
            String listeReference = results.getString("listeReference");
            int reduction = results.getInt("reduction");
            
            Promo promo = new Promo(idPromo, listeReference, reduction);
            promos.add(promo);
        }

        return promos;
    }
    
    public void insert() throws SQLException {
        String sql = "INSERT INTO " + TABLE_NAME + "(" + FIELDS[0];
        for (int i = 1; i < FIELDS.length; i++) {
            sql += ", " + FIELDS[i];
        }
        sql += ") VALUES("
                + "'" + this.idPromo
                + ", '" + this.listeReference + "'"
                + ", '" + this.reduction
                + ")";

        Connector.insert(sql);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.idPromo;
        hash = 37 * hash + Objects.hashCode(this.listeReference);
        hash = 37 * hash + this.reduction;
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
        final Promo other = (Promo) obj;
        if (this.idPromo != other.idPromo) {
            return false;
        }
        if (this.reduction != other.reduction) {
            return false;
        }
        if (!Objects.equals(this.listeReference, other.listeReference)) {
            return false;
        }
        return true;
    }

    public int getIdPromo() {
        return idPromo;
    }

    public void setIdPromo(int idPromo) {
        this.idPromo = idPromo;
    }

    public String getListeReference() {
        return listeReference;
    }

    public void setListeReference(String listeReference) {
        this.listeReference = listeReference;
    }

    public int getReduction() {
        return reduction;
    }

    public void setReduction(int reduction) {
        this.reduction = reduction;
    }

    
    
}
