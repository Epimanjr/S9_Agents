package fr.miage.supermarche.util.strategy;

import fr.miage.supermarche.persist.RequetesInternes;
import fr.miage.supermarche.persist.Soldes;
import fr.miage.supermarche.util.Periode;
import fr.miage.supermarche.util.PeriodeType;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Définit une stratégie simple de définition des périodes
 *
 * @author Antoine NOSAL
 * @author Maxime BLAISE
 * @author Guillaume DÉNISSE
 * @author Geoffrey GAILLARD
 */
public class PeriodeSimpleStrategy implements PeriodeStrategy {

    /**
     * La période p en paramètre est la période actuelle. La période retournée
     * est la nouvelle période (p+1). L'idée, c'est de savoir si on est : - en
     * période standard (jan. -> oct.) (impossible de vendre à perte) - en
     * période de soldes des fêtes (nov. -> déc.) (possible de faire des
     * promotions en réduisant les prix jusqu’à 30% à condition qu’il s’agisse
     * de lots de produits différents) - en période de soldes flottantes (quand
     * on veut, 10 jours max deux fois par an) (prévenir tous les agents au
     * moins 2 semaines avant, possible de faire des réductions sans aller
     * en-deçà du prix coûtant) NB: Si la nouvelle période est la même que celle
     * en paramètre, Alors on retourne le paramètre p.
     *
     * @param p Période actuelle
     * @return Periode Nouvelle période
     */
    @Override
    public Periode define(Periode p) {
        System.out.println("[INTERNE] Définition de la période en cours ...");

        Periode nouvellePeriode = null;
        if (Periode.dateDebutSoldesFlottantes == null) {
            // Si on est dans la période de soldes, on regarde si on atteint pas la fin
            if (p.getType() == PeriodeType.SOLDES_FLOTTANTES) {
                GregorianCalendar dateCourante = new GregorianCalendar();
                if (dateCourante.compareTo(p.getDateFin()) >= 0) {
                    // Soldes terminés !
                    nouvellePeriode = new Periode(dateCourante);
                    nouvellePeriode.setStrategy(p.getStrategy());
                }
            } else {
                // Doit-on mettre la période de soldes flottantes ?
                int nbJoursRestants = RequetesInternes.nbJoursSoldesFlottantesRestants();
                if (nbJoursRestants > 0) {
                    double alea = Math.random() * 100;
                    if (alea < 1.0) {
                        // Ok pour 3 jours :) 
                        int nbJours = (nbJoursRestants < 3) ? nbJoursRestants : 3;

                        GregorianCalendar dateDebut = new GregorianCalendar();
                        dateDebut.add(GregorianCalendar.DAY_OF_YEAR, 15);
                        Periode.dateDebutSoldesFlottantes = dateDebut;
                        Periode.nbJoursSoldesFlottantes = nbJours;
                        p.setPrevenirSoldesFlottantes(true);
                    }
                }
            }
        } else {
            // Si vérifie si on atteint pas le début de la période de soldes flottantes
            GregorianCalendar dateCourante = new GregorianCalendar();
            if (dateCourante.compareTo(Periode.dateDebutSoldesFlottantes) >= 0) {
                GregorianCalendar dateFin = new GregorianCalendar();
                dateFin.add(GregorianCalendar.DAY_OF_YEAR, Periode.nbJoursSoldesFlottantes);
                nouvellePeriode = new Periode(dateCourante, dateFin, PeriodeType.SOLDES_FLOTTANTES);
                nouvellePeriode.setStrategy(p.getStrategy());
                Periode.dateDebutSoldesFlottantes = null;
                
                SimpleDateFormat sdf = new SimpleDateFormat("dd--MM-YYYY");
                String sDateDebut = sdf.format(dateCourante.getTime());
                String sDateFin = sdf.format(dateFin.getTime());
                Soldes solde = new Soldes(sDateDebut, sDateFin, dateCourante.get(GregorianCalendar.YEAR), Periode.nbJoursSoldesFlottantes);
                try {
                    solde.insert();
                } catch (SQLException ex) {
                    System.err.println("Impossible d'insérer une instance de solde dans la base");
                }
            }
        }

        // Tests des deux cas standards|periodesNoel
        if (p.getType() != PeriodeType.SOLDES_FLOTTANTES) {
            GregorianCalendar dateCourante = new GregorianCalendar();
            if (p.getType() == PeriodeType.STANDARD && dateCourante.get(GregorianCalendar.MONTH) == GregorianCalendar.NOVEMBER) {
                nouvellePeriode = new Periode(dateCourante);
            } else if (p.getType() == PeriodeType.SOLDES_FETES && dateCourante.get(GregorianCalendar.MONTH) == GregorianCalendar.JANUARY) {
                nouvellePeriode = new Periode(dateCourante);
            }
        }
        
        System.out.println("[INTERNE] Définition de la période terminée");
        return (nouvellePeriode != null) ? nouvellePeriode : p;
    }

}
