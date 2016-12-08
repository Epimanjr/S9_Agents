package fr.miage.supermarche.behavior;

import fr.miage.supermarche.util.PeriodeType;
import fr.miage.supermarche.util.Periode;
import fr.miage.supermarche.util.strategy.PeriodeSimpleStrategy;
import fr.miage.supermarche.util.Stock;
import fr.miage.supermarche.util.Tarification;
import fr.miage.supermarche.util.strategy.StockSimpleStrategy;
import fr.miage.supermarche.util.strategy.TarificationSimpleStrategy;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

/**
 *
 * @author Antoine NOSAL
 * @author Maxime BLAISE
 * @author Guillaume DÉNISSE
 * @author Geoffrey GAILLARD
 */
public class SpermarcheBehavior extends TickerBehaviour {

    /**
     * Stock à gérer
     */
    private Stock stock;
    
    /**
     * Période actuelle (standard, fêtes, soldes flottantes)
     */
    private Periode periodeActuelle;

    /**
     * Tarification
     */
    private Tarification tarification;
    
    /**
     * Instance une SupermarcheBehavior qui
     * s'occupe de toute la gestion interne
     *
     * @param a Agent implémentant ce comportement
     * @param period Le comportement est répété selon cette période
     */
    public SpermarcheBehavior(Agent a, long period) {
        super(a, period);
        // Création d'un stock et sélection de la stratégie
        this.stock = new Stock();
        this.stock.setStrategy(new StockSimpleStrategy());
        // Création d'une période et sélection de la stratégie de calcul
        this.periodeActuelle = new Periode(null, null, PeriodeType.STANDARD);
        this.periodeActuelle.setStrategy(new PeriodeSimpleStrategy());
        // Création d'une tarification et sélection de la stratégie de calcul
        this.tarification = new Tarification();
        this.tarification.setStrategy(new TarificationSimpleStrategy());
    }

    /**
     * Gère le supermarché (Méthode appelée en boucle à chaque période)
     */
    @Override
    protected void onTick() {
        // Gestion des stocks
        this.stock.analyse();
        // TODO : envoyer la map this.stock.aCommander à la gestion des fournisseurs
        // Cette map contient la liste des produits à réapprovisionner avec la quantité

        // Gestion des périodes
        this.periodeActuelle = this.periodeActuelle.define(periodeActuelle);
        if(this.periodeActuelle.isPrevenirSoldesFlottantes()) {
            // TODO (prévenir les clients : soldes dans 2 semaines)
        }
        switch (this.periodeActuelle.getType()) {
            case STANDARD:
                // Impossible de vendre à perte
                break;
            case SOLDES_FETES:
                // Possible de faire des promotions en réduisant les prix jusqu’à 30%
                // à condition qu’il s’agisse de lots de produits différents
                break;
            case SOLDES_FLOTTANTES:
                // Prévenir tous les agents au moins 2 semaines avant 
                // Possible de faire des réductions sans aller en-deçà du prix coûtant
                break;
            default:
                break;
        }    
        
        // Gestion des PVHT (Prix de Vente Hors Taxes)
        this.tarification.update();
        
    }

}
