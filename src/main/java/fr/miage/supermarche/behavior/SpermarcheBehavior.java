package fr.miage.supermarche.behavior;

import fr.miage.supermarche.util.PeriodeType;
import fr.miage.supermarche.util.Periode;
import fr.miage.supermarche.persist.Produit;
import fr.miage.supermarche.util.PeriodeSimpleStrategy;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Antoine NOSAL
 * @author Maxime BLAISE
 * @author Guillaume DÉNISSE
 * @author Geoffrey GAILLARD
 */
public class SpermarcheBehavior extends TickerBehaviour {

    /**
     * Quantités minimum pour chaque produit
     */
    private Map<String, Integer> qteMinProduits;
    
    /**
     * Période actuelle (standard, fêtes, soldes flottantes)
     */
    private Periode periodeActuelle;

    /**
     * Instancie un
     *
     * @param a Agent implémentant ce comportement
     * @param period Le comportement est répété selon cette période
     */
    public SpermarcheBehavior(Agent a, long period) {
        super(a, period);
        this.initQteMinProduits();
        // Création d'une période et sélection de la stratégie de calcul
        this.periodeActuelle = new Periode(null, null, PeriodeType.STANDARD);
        this.periodeActuelle.setStrategy(new PeriodeSimpleStrategy());
    }

    public void initQteMinProduits() {
        this.qteMinProduits.put("BOBI16", 250);
        this.qteMinProduits.put("BOEA901", 100);
        this.qteMinProduits.put("BOMI952", 150);
        this.qteMinProduits.put("BOSN991", 50);
        this.qteMinProduits.put("BOWH188", 450);
    }

    /**
     * Gère le supermarché (Méthode appelée en boucle à chaque période)
     */
    @Override
    protected void onTick() {
        // Gestion des stocks
        try {
            // Pour chaque quantité minimale par produit
            for (Map.Entry<String, Integer> qteMinProduit : this.qteMinProduits.entrySet()) {
                Produit produit = Produit.getByReference(qteMinProduit.getKey());
                /**
                 * STRATÉGIE
                 * Si le stock disponible est inférieure à la moitié de la quantité souhaitée
                 * On doit se réapprovisionner
                 */
                if (produit.getStock() < qteMinProduit.getValue() / 2) {
                    // TODO (lancer un réapprovisionnement)
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SpermarcheBehavior.class.getName()).log(Level.SEVERE, null, ex);
        }

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
        
    }

}
