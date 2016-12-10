package fr.miage.supermarche.util;

import fr.miage.supermarche.persist.Produit;
import fr.miage.supermarche.util.strategy.TarificationStrategy;
import java.util.List;

/**
 * Classe de gestion des stocks
 * (s'appuie sur une stratégie à définir)
 * @author Antoine NOSAL
 * @author Maxime BLAISE
 * @author Guillaume DÉNISSE
 * @author Geoffrey GAILLARD
 */
public class Tarification{
    
    /**
     * Stratégie de gestion des tarifs
     */
    private TarificationStrategy strategy;
    
    /**
     * Période en cours
     */
    private PeriodeType periodeType;
    
    public Tarification() {
    }

    /**
     * Met à jour les tarifs
     * @return 
     */
    public void update(List<Produit> produits) {
        this.strategy.update(this, produits);
    }

    public TarificationStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(TarificationStrategy strategy) {
        this.strategy = strategy;
    }

    public PeriodeType getPeriodeType() {
        return periodeType;
    }

    public void setPeriodeType(PeriodeType periodeType) {
        this.periodeType = periodeType;
    }

}
