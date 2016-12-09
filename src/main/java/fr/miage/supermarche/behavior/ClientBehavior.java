package fr.miage.supermarche.behavior;

import fr.miage.agents.api.message.Message;
import fr.miage.agents.api.message.recherche.Rechercher;
import fr.miage.agents.api.message.recherche.ResultatRecherche;
import fr.miage.agents.api.message.relationclientsupermarche.Achat;
import fr.miage.agents.api.message.relationclientsupermarche.ResultatDistance;
import fr.miage.agents.api.model.Produit;
import fr.miage.supermarche.persist.RequetesClient;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guillaume DENIS
 */
public class ClientBehavior extends CyclicBehaviour {

    public ClientBehavior(Agent a) {
        super(a);
    }
    
    @Override
    public void action() {
        ACLMessage aclMsg = this.getAgent().receive();

        // On gère le message reçu par la plateforme
        if (aclMsg != null) {
            try {
                // Récupèration du Message de l'API
                Message recu = (Message) aclMsg.getContentObject();

                switch (recu.type) {
                    // Le client désire rechercher un Produit
                    case Recherche:
                        Rechercher r = (Rechercher) recu;
                        this.gererRecherche(r);  
                        break;

                    // On reçoit une demande pour acheter des produits
                    case InitierAchat:
                        Achat a = (Achat) recu;

                        // traiter la liste de courses
                        // renvoyer un résultat achat
                        break;
                    // Demande de la distance
                    case DemandeDistance:
                        this.gererDemandeDistance();
                        break;
                    default:
                        break;
                }

            } catch (UnreadableException e) {
                Logger.getLogger(ClientBehavior.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
    /**
     * Gère les demandes de distance
     */
    private void gererDemandeDistance(){
        // on récupère notre distance \m/
        double distance = 66.6;
        int delai = 3;
        ResultatDistance rd = new ResultatDistance();
        rd.distance = distance;
        rd.delai = delai;
        
        // on envoit notre réponse
        this.envoyerMessage(rd);
    }
    
    /**
     * Gère la recherche d'un produit
     * @param r le message reçu avec les informatios de Recherche
     */
    private void gererRecherche(Rechercher r) {
        // Récupération de notre liste de produits en fonction des critères
        List<Integer> ids = new ArrayList<>();
        List<Produit> produits = new ArrayList<Produit>();
        try {
            ids = RequetesClient.getIdWithCriteres("", r.nomCategorie, r.marque, ((int) r.prixMin), ((int) r.prixMax));
        } catch (SQLException ex) {
            Logger.getLogger(ClientBehavior.class.getName()).log(Level.SEVERE, null, ex);
        }

        // TODO récupérer des produits avec un id long plutôt qu'une référence
        // ids.forEach(it -> produits.add(Produit.getByReference(it)));
        
// on met notre liste dans un message de l'api
        ResultatRecherche rr = new ResultatRecherche();
        rr.produitList = produits;
        rr.Session = r.session;
        
        // on envoit le message
        this.envoyerMessage(rr);
    }
    
    /**
     * Envoi le message aux agents
     * @param s l'objet de l'api à envoyer
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
