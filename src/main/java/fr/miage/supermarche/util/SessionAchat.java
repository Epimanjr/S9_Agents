package fr.miage.supermarche.util;

import fr.miage.agents.api.message.TypeMessage;

/**
 *
 * @author Antoine NOSAL
 */
public class SessionAchat {

    private Integer idProduit;
    private Integer qteSouhaitee;
    private TypeMessage etat;

    public SessionAchat(int idProduit, int qteSouhaitee, TypeMessage etat) {
        this.idProduit = idProduit;
        this.qteSouhaitee = qteSouhaitee;
        this.etat = etat;
    }

    public Integer getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Integer idProduit) {
        this.idProduit = idProduit;
    }

    public Integer getQteSouhaitee() {
        return qteSouhaitee;
    }

    public void setQteSouhaitee(Integer qteSouhaitee) {
        this.qteSouhaitee = qteSouhaitee;
    }

    public TypeMessage getEtat() {
        return etat;
    }

    public void setEtat(TypeMessage etat) {
        this.etat = etat;
    }

}
