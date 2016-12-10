package fr.miage.supermarche.util;

import fr.miage.supermarche.util.strategy.AchatFournisseurStrategy;

/**
 * Représente un achat fournisseur
 * @author Antoine NOSAL
 * @author Maxime BLAISE
 * @author Guillaume DÉNISSE
 * @author Geoffrey GAILLARD
 */
public class AchatFournisseur {

    private Integer idProduit;
    private float prixProposeParFournisseur;
    private Integer qteSouhaitee;
    private Integer qteDisponibleChezFournisseur;
    private float prixANegocier;
    
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

    public float getPrixProposeParFournisseur() {
        return prixProposeParFournisseur;
    }

    public void setPrixProposeParFournisseur(float prixProposeParFournisseur) {
        this.prixProposeParFournisseur = prixProposeParFournisseur;
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

    public float getPrixANegocier() {
        return prixANegocier;
    }

    public void setPrixANegocier(float prixANegocier) {
        this.prixANegocier = prixANegocier;
    }
    
}
