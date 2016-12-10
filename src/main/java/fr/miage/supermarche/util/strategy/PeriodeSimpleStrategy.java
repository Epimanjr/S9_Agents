package fr.miage.supermarche.util.strategy;

import fr.miage.supermarche.util.Periode;
import fr.miage.supermarche.util.PeriodeType;

/**
 * Définit une stratégie simple de définition des périodes
 * @author Antoine NOSAL
 * @author Maxime BLAISE
 * @author Guillaume DÉNISSE
 * @author Geoffrey GAILLARD
 */
public class PeriodeSimpleStrategy implements PeriodeStrategy {

    /**
     * La période p en paramètre est la période actuelle.
     * La période retournée est la nouvelle période (p+1)
     * L'idée, c'est de savoir si on est :
     *   - en période standard (jan. -> oct.)
     *          (impossible de vendre à perte)
     *   - en période de soldes des fêtes (nov. -> déc.)
     *          (possible de faire des promotions en réduisant les prix jusqu’à 30%
     *           à condition qu’il s’agisse de lots de produits différents)
     *   - en période de soldes flottantes (quand on veut, 10 jours max deux fois par an)
     *          (prévenir tous les agents au moins 2 semaines avant, 
     *           possible de faire des réductions sans aller en-deçà du prix coûtant)
     * NB: Si la nouvelle période est la même que celle en paramètre,
     * Alors on retourne le paramètre p.
     * 
     * @param p         Période actuelle
     * @return Periode  Nouvelle période
     */
    @Override
    public Periode define(Periode p) {
        Periode nouvellePeriode = new Periode(null, null, PeriodeType.STANDARD);
        return nouvellePeriode;
    }

}
