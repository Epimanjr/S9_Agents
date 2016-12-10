package fr.miage.supermarche.util;

import fr.miage.supermarche.util.strategy.PeriodeStrategy;
import java.util.Date;

/**
 * Classe de gestion des périodes (standard, soldes, etc.) d'un supermarché
 * (s'appuie sur une stratégie à choisir)
 * @author Antoine NOSAL
 * @author Maxime BLAISE
 * @author Guillaume DÉNISSE
 * @author Geoffrey GAILLARD
 */
public class Periode {

    /**
     * Stratégie de définition
     */
    private PeriodeStrategy strategy;
    
    /**
     * Date de début de la période
     */
    private Date dateDebut;
    
    /**
     * Date de fin de la période
     */
    private Date dateFin;
    
    /**
     * Type de la période
     * (Standard, soldes fêtes, soldes flottantes)
     */
    private PeriodeType type;
    private boolean prevenirSoldesFlottantes;

    public Periode(Date dateDebut, Date dateFin, PeriodeType type) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.type = type;
        this.prevenirSoldesFlottantes = false;
    }
    
    /**
     * Définit ou non une nouvelle période en
     * fonction d'une période en paramètre
     * @param p Période à traiter
     * @return 
     */
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
