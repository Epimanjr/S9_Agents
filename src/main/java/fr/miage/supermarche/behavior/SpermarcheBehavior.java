package fr.miage.supermarche.behavior;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Antoine NOSAL
 * @author Maxime BLAISE
 * @author Guillaume DÉNISSE
 * @author Geoffrey GAILLARD
 */
public class SpermarcheBehavior extends TickerBehaviour{

    /**
     * Quantités minimum pour chaque produit
     */
    private Map<String, Integer> qteMinProduits;

    /**
     * Instancie un 
     * @param a         Agent implémentant ce comportement
     * @param period    Le comportement est répété selon cette période
     */
    public SpermarcheBehavior(Agent a, long period) {
        super(a, period);
        this.initQteMinProduits();
    }
    
    public void initQteMinProduits() {
        this.qteMinProduits.put("BOBI16", 250);
        this.qteMinProduits.put("BOEA901", 100);
        this.qteMinProduits.put("BOMI952", 150);
        this.qteMinProduits.put("BOSN991", 50);
        this.qteMinProduits.put("BOWH188", 450);
    }
    
    /**
     * Gère le supermarché
     * (Méthode appelée en boucle à chaque période)
     */
    @Override
    protected void onTick() {
        // Gestion des stocks
        
        
        // Gestion des soldes
        
        
        // Gestion des PVHT (Prix de Vente Hors Taxes)
    }
    
}
