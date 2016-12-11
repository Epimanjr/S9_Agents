/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.supermarche.test;

import fr.miage.agents.api.message.Message;
import fr.miage.agents.api.message.recherche.Rechercher;
import fr.miage.agents.api.message.recherche.ResultatRecherche;
import fr.miage.agents.api.message.relationclientsupermarche.Achat;
import fr.miage.agents.api.message.relationclientsupermarche.ResultatAchat;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kangoula
 */
public class ClientTestBehavior extends CyclicBehaviour {

    private static final MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.INFORM);
    
    public ClientTestBehavior(Agent a) {
        super(a);
    }

    @Override
    public void action() {
        try {
            System.out.println("[CLIENT_TEST] Recherche par id");
            Rechercher id = new Rechercher();
            id.idProduit = new Long(84);
            id.session = UUID.randomUUID();
            this.envoyerMessage(id);

            System.out.println("[CLIENT_TEST] Recherche par critères");
            Rechercher crit = new Rechercher();
            crit.nomCategorie = "High-Tech";
            crit.prixMax = 150;
            crit.prixMin = 100;
            crit.marque = "";
            crit.session = UUID.randomUUID();
            this.envoyerMessage(crit);
            
            System.out.println("[CLIENT_TEST] Achat");
            Achat a = new Achat();
            Map<Long, Integer> courses = new HashMap<>();
            courses.put(new Long(1), 1);
            a.Session = UUID.randomUUID();
            a.listeCourses = courses;
            this.envoyerMessage(a);

            
            Optional<ACLMessage> aclmsg = Optional.ofNullable(this.getAgent().blockingReceive(mt));

            if (aclmsg.isPresent()) {
                Message recu = (Message) (aclmsg.get().getContentObject());

                switch (recu.type) {
                    case ResultatRecherche:
                        ResultatRecherche rr = (ResultatRecherche) recu;
                        System.out.println("[CLIENT_TEST] Resultat de la recherche reçu");
                        rr.produitList.forEach(p -> System.out.println("Produit : " + p.idProduit + ", " + p.nomProduit + ", " + p.idCategorie));
                        break;
                    case ResultatAchatClient:
                        ResultatAchat ra = (ResultatAchat) recu;
                        System.out.println("[CLIENT_TEST] Resultat des achats reçu");
                        ra.courses.forEach((key, value) -> System.out.println("produit : " + key + ", quantite reçue : " + value));
                        break;
                    default:
                        break;
                }
            } 
        } catch (UnreadableException ex) {
            Logger.getLogger(ClientTestBehavior.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Envoi le message aux agents
     *
     * @param s l'objet à envoyer
     */
    private void envoyerMessage(Serializable s) {
        try {
            // création du message pour JADE
            ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
            msg.addReceiver(new AID("supermarche", AID.ISLOCALNAME));
            msg.setContentObject(s);

            // envoit du message
            this.getAgent().send(msg);

        } catch (IOException ex) {
            Logger.getLogger(FournisseurTestBehavior.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
