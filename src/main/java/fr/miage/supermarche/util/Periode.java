package fr.miage.supermarche.util;

import java.util.Date;

/**
 *
 * @author Antoine NOSAL
 * @author Maxime BLAISE
 * @author Guillaume DÉNISSE
 * @author Geoffrey GAILLARD
 */
public class Periode {

    // Stratégie de calcul
    private PeriodeStrategy strategy;
    
    private Date dateDebut;
    private Date dateFin;
    private PeriodeType type;
    private boolean prevenirSoldesFlottantes;

    public Periode(Date dateDebut, Date dateFin, PeriodeType type) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.type = type;
        this.prevenirSoldesFlottantes = false;
    }
    
    public Periode define(Periode p) {
        return strategy.define(p);
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

    public boolean isPrevenirSoldesFlottantes() {
        return prevenirSoldesFlottantes;
    }

    public void setPrevenirSoldesFlottantes(boolean prevenirSoldesFlottantes) {
        this.prevenirSoldesFlottantes = prevenirSoldesFlottantes;
    }

    public PeriodeStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(PeriodeStrategy strategy) {
        this.strategy = strategy;
    }
    
}
