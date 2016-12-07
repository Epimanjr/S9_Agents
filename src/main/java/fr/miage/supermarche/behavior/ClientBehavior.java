/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.supermarche.behavior;

import fr.miage.agents.api.message.Message;
import fr.miage.agents.api.message.auth.DemanderSession;
import fr.miage.agents.api.message.auth.ResultatDemandeSession;
import fr.miage.agents.api.message.recherche.Rechercher;
import fr.miage.agents.api.message.recherche.ResultatRecherche;
import fr.miage.agents.api.message.relationclientsupermarche.Achat;
import fr.miage.agents.api.model.Produit;
import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author Guillaume DENIS
 */
public class ClientBehavior extends CyclicBehaviour{

    @Override
    public void action() {
        ACLMessage aclMsg = this.getAgent().receive();

        // Notre liste de produits
        List<Produit> produits;
        
        // On gère le message reçu par la plateforme
        if(aclMsg != null){
            try {
                // Récupèration du Message de l'API
                Message msg = (Message)aclMsg.getContentObject();

                switch(msg.type){
                    // Le client désire rechercher un Produit
                    case Recherche:
                        Rechercher r = (Rechercher)msg;
                        
                        //TODO récupérer le produit depuis nos données
                        produits = null;
                        
                        // on met notre liste dans un message
                        ResultatRecherche rr = new ResultatRecherche();
                        rr.produitList = produits;
                        rr.Session = r.session;
                        break;
                        
                    // On reçoit une demande pour acheter des produits
                    case InitierAchat:
                        Achat a = (Achat)msg;
                        
                        // traiter la liste de courses
                        
                        // renvoyer un résultat achat
                        break;
                    // Demande de la distance
                    case Distance:
                        break;
                    default:
                        break;
                }

            } catch (UnreadableException e) {
                e.printStackTrace();
            } 
        }
    }
    
    
}
