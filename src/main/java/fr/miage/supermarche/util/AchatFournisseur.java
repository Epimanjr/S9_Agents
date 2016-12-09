package fr.miage.supermarche.util;

import fr.miage.supermarche.util.strategy.AchatFournisseurStrategy;

/**
 * 
 * @author Antoine NOSAL
 * @author Maxime BLAISE
 * @author Guillaume DÉNISSE
 * @author Geoffrey GAILLARD
 */
public class AchatFournisseur {

    private Integer idProduit;
    private float prix;
    private Integer qteSouhaitee;
    private Integer qteDisponibleChezFournisseur;
    
    /**
     * Stratégie
     */
    private AchatFournisseurStrategy strategy;

    public AchatFournisseur() {
    }

    public AchatFournisseurStrategy getStrategy() {
        return strategy;
    }
    
    public boolean approuver() {
        return this.strategy.approuver(this);
    }

    public void setStrategy(AchatFournisseurStrategy strategy) {
        this.strategy = strategy;
    }

    public Integer getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Integer idProduit) {
        this.idProduit = idProduit;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Integer getQteSouhaitee() {
        return qteSouhaitee;
    }

    public void setQteSouhaitee(Integer qteSouhaitee) {
        this.qteSouhaitee = qteSouhaitee;
    }

    public Integer getQteDisponibleChezFournisseur() {
        return qteDisponibleChezFournisseur;
    }

    public void setQteDisponibleChezFournisseur(Integer qteDisponibleChezFournisseur) {
        this.qteDisponibleChezFournisseur = qteDisponibleChezFournisseur;
    }
    
}
