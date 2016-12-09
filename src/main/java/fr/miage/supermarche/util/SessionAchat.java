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
    
    
    
}
