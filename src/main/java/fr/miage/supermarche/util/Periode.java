package fr.miage.supermarche.util;

import fr.miage.supermarche.util.strategy.PeriodeStrategy;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Classe de gestion des périodes (standard, soldes, etc.) d'un supermarché
 * (s'appuie sur une stratégie à choisir)
 *
 * @author Antoine NOSAL
 * @author Maxime BLAISE
 * @author Guillaume DÉNISSE
 * @author Geoffrey GAILLARD
 */
public class Periode {

    /**
     * Si on prévoit une période de solde flottante, il est nécessaire de
     * retenir la date de début.
     */
    public static GregorianCalendar dateDebutSoldesFlottantes = null;
    
    /**
     * Combien de temps vont durer les prochaines soldes flottantes.
     */
    public static int nbJoursSoldesFlottantes = 0;
    
    /**
     * Stratégie de définition
     */
    private PeriodeStrategy strategy;

    /**
     * Date de début de la période
     */
    private GregorianCalendar dateDebut;

    /**
     * Date de fin de la période
     */
    private GregorianCalendar dateFin;

    /**
     * Type de la période (Standard, soldes fêtes, soldes flottantes)
     */
    private PeriodeType type;

    /**
     * true si on décide que dans 2 semaines, On sera
     */
    private boolean prevenirSoldesFlottantes;

    public Periode() {
        this.dateDebut = new GregorianCalendar();
        init();
    }
    
    public Periode(GregorianCalendar dateDebut) {
        this.dateDebut = dateDebut;
        init();
    }
    
    private void init() {
        this.dateFin = new GregorianCalendar();
        
        int month = this.dateDebut.get(GregorianCalendar.MONTH);
        if(month == GregorianCalendar.NOVEMBER || month == GregorianCalendar.DECEMBER) {
            this.dateFin.set(GregorianCalendar.MONTH, GregorianCalendar.DECEMBER);
            this.dateFin.set(GregorianCalendar.DAY_OF_MONTH, 31);
            this.setType(PeriodeType.SOLDES_FETES);
        } else {
            this.dateFin.set(GregorianCalendar.MONTH, GregorianCalendar.OCTOBER);
            this.dateFin.set(GregorianCalendar.DAY_OF_MONTH, 31);
            this.setType(PeriodeType.STANDARD);
        }
    }
    
    public Periode(GregorianCalendar dateDebut, GregorianCalendar dateFin, PeriodeType type) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.type = type;
        this.prevenirSoldesFlottantes = false;
    }

    /**
     * Définit ou non une nouvelle période en fonction d'une période en
     * paramètre
     *
     * @param p Période à traiter
     * @return
     */
    public Periode define(Periode p) {
        return strategy.define(p);
    }

    public GregorianCalendar getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(GregorianCalendar dateDebut) {
        this.dateDebut = dateDebut;
    }

    public GregorianCalendar getDateFin() {
        return dateFin;
    }

    public void setDateFin(GregorianCalendar dateFin) {
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
