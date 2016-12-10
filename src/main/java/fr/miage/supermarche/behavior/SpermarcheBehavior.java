package fr.miage.supermarche.behavior;

import fr.miage.supermarche.util.MessageInterne;
import fr.miage.supermarche.util.MessageInterneType;
import fr.miage.supermarche.util.PeriodeType;
import fr.miage.supermarche.util.Periode;
import fr.miage.supermarche.util.strategy.PeriodeSimpleStrategy;
import fr.miage.supermarche.util.Stock;
import fr.miage.supermarche.util.Tarification;
import fr.miage.supermarche.util.strategy.StockSimpleStrategy;
import fr.miage.supermarche.util.strategy.TarificationSimpleStrategy;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import java.io.IOException;
import java.io.Serializable;
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
     * Instancie une SupermarcheBehavior qui
     * s'occupe de toute la gestion interne
     * (stratégie simple prédéfinie)
     *
     * @param a         Agent implémentant ce comportement
     * @param period    Le comportement est répété selon cette période
     */
    public SpermarcheBehavior(Agent a, long period) {
        super(a, period);
        // Création d'un stock et sélection de la stratégie
        this.stock = new Stock();
        this.stock.setStrategy(new StockSimpleStrategy(0.50));
        // Création d'une période et sélection de la stratégie de calcul
        this.periodeActuelle = new Periode(null, null, PeriodeType.STANDARD);
        this.periodeActuelle.setStrategy(new PeriodeSimpleStrategy());
        // Création d'une tarification et sélection de la stratégie de calcul
        this.tarification = new Tarification();
        this.tarification.setStrategy(new TarificationSimpleStrategy());
    }

    /**
     * Instancie une SupermarcheBehavior qui
     * s'occupe de toute la gestion interne
     * 
     * @param a             Agent implémentant ce comportement
     * @param period        Le comportement est répété selon cette période
     * @param stock         Gestion des stocks
     * @param periode       Gestion de la période courante
     * @param tarification  Gestion de la tarification
     */
    public SpermarcheBehavior(Agent a, long period, Stock stock, Periode periode, Tarification tarification) {
        super(a, period);
        this.stock = stock;
        this.periodeActuelle = periode;
        this.tarification = tarification;
    }
    
    /**
     * Gère le supermarché (Méthode appelée en boucle à chaque période)
     */
    @Override
    protected void onTick() {
        System.out.println("onTick");
        // Gestion des stocks
        this.stock.analyse();
        // Envoyer la map this.stock.aCommander à la gestion des fournisseurs si elle n'est pas vide
        // Cette map contient la liste des produits à réapprovisionner avec la quantité
        if(!this.stock.getaCommander().isEmpty()) {
            MessageInterne message = new MessageInterne(MessageInterneType.demandeReapprov);
            message.aCommander = this.stock.getaCommander();
            // TODO : Envoyer le message à FournisseurBehavior
            // Je ne pense pas que la méthode envoyerMessage fait le job...
            System.out.println("il est temps d'envoyer un message");
            this.envoyerMessage(message);
        }

        // Gestion des périodes
        this.periodeActuelle = this.periodeActuelle.define(this.periodeActuelle);;
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
    
    /**
     * Envoi le message aux agents
     * @param s l'objet à envoyer
     */
    private void envoyerMessage(Serializable s){
        try {
            // création du message pour JADE
            ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
            msg.setContentObject(s);
            
            // envoit du message
            this.getAgent().send(msg);
            
        } catch (IOException ex) {
            Logger.getLogger(ClientBehavior.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
