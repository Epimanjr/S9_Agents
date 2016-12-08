package fr.miage.supermarche.behavior;

import java.util.Date;

/**
 *
 * @author Antoine NOSAL
 * @author Maxime BLAISE
 * @author Guillaume DÉNISSE
 * @author Geoffrey GAILLARD
 */
public class Periode {

    private Date dateDebut;
    private Date dateFin;
    private PeriodeType type;

    public Periode(Date dateDebut, Date dateFin, PeriodeType type) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.type = type;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public PeriodeType getType() {
        return type;
    }

    public void setType(PeriodeType type) {
        this.type = type;
    }
    
    
    
}
