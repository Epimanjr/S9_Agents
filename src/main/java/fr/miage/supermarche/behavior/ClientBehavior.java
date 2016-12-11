package fr.miage.supermarche.behavior;

import fr.miage.agents.api.message.Message;
import fr.miage.agents.api.message.recherche.Rechercher;
import fr.miage.agents.api.message.recherche.ResultatRecherche;
import fr.miage.agents.api.message.relationclientsupermarche.Achat;
import fr.miage.agents.api.message.relationclientsupermarche.ResultatAchat;
import fr.miage.agents.api.message.relationclientsupermarche.ResultatDistance;
import fr.miage.supermarche.persist.Produit;
import fr.miage.supermarche.persist.RequetesClient;
import fr.miage.supermarche.persist.RequetesInternes;
import fr.miage.supermarche.util.ApiProduit;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

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
        try {
            ACLMessage aclMsg = this.getAgent().receive();

            // On attend de recevoir des messages
            if (aclMsg != null) {
                // Si on reçoit un message
                if (aclMsg.getContentObject() instanceof Message) {
                    Message recu = (Message) aclMsg.getContentObject();
                    switch (recu.type) {
                        // Le client désire rechercher un Produit
                        case Recherche:
                            Rechercher r = (Rechercher) recu;
                            this.gererRecherche(r);
                            break;

                        // On reçoit une demande pour acheter des produits
                        case AchatClient:
                            this.gererAchat(recu);
                            break;
                        // Demande de la distance
                        case DemandeDistance:
                            this.gererDemandeDistance();
                            break;
                        default:
                            break;
                    }
                }
            }
        } catch (UnreadableException e) {
            Logger.getLogger(ClientBehavior.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * Gère un achat.
     *
     * @param recu Message reçu.
     */
    private void gererAchat(Message recu) {
        // Initialisation
        Achat achat = (Achat) recu;
        ResultatAchat resultatAchat = new ResultatAchat();
        resultatAchat.session = achat.Session;

        resultatAchat.courses = new HashMap<>();
        Iterator<Long> itProduits = achat.listeCourses.keySet().iterator();
        while (itProduits.hasNext()) {
            Long idProduit = itProduits.next();
            Integer qteProduit = achat.listeCourses.get(idProduit);

            // on retourne la quantité de produit, si la quantité est supérieure au sotck, on retourne la valeur du stock
            int qteRetiree = RequetesInternes.retirerProduit(idProduit, qteProduit);

            fr.miage.agents.api.model.Produit p = new fr.miage.agents.api.model.Produit();
            p.idProduit = idProduit;

            resultatAchat.courses.put(p, qteRetiree);
        }

        // Fin des courses !
        this.envoyerMessage(resultatAchat);
    }

    /**
     * Gère les demandes de distance
     * @deprecated 
     */
    private void gererDemandeDistance() {
        // on récupère notre distance \m/
        double distance = 66.6;
        int delai = 5;
        ResultatDistance rd = new ResultatDistance();
        rd.distance = distance;
        rd.delai = delai;

        // on envoit notre réponse
        this.envoyerMessage(rd);
    }

    /**
     * Gère la recherche d'un produit
     *
     * @param r le message reçu avec les informatios de Recherche
     */
    private void gererRecherche(Rechercher r) {
        Long id = r.idProduit;
        if (id > 0) {
            rechercheProduitParId(r.idProduit, r.session);
        } else {
            rechercheProduitParCriteres(r);
        }
    }

    private void rechercheProduitParId(Long id, UUID session) {
        Optional<Produit> maybe_p = Produit.getById(id);
        List<ApiProduit> ps = new LinkedList<>();

        if (maybe_p.isPresent()) {
            ApiProduit evilP = maybe_p.get().toApiProduit();
            ps.add(evilP);
        }

        ResultatRecherche rr = new ResultatRecherche();
        rr.produitList = ApiProduit.toRawApiProduitList(ps);
        rr.Session = session;
        this.envoyerMessage(rr);
    }

    private void rechercheProduitParCriteres(Rechercher r) {
        // Récupération de notre liste de produits en fonction des critères
        List<Integer> ids = new ArrayList<>();

        try {
            ids = RequetesClient.getIdWithCriteres("", r.nomCategorie, r.marque, ((int) r.prixMin), ((int) r.prixMax));

        } catch (SQLException ex) {
            Logger.getLogger(ClientBehavior.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        ArrayList<Produit> produits = new ArrayList<>();
        ArrayList<Integer> notFound = new ArrayList<>();  // TODO, en faire quelquechose ?

        ids.stream().map(id -> {
            // for each id, make an hmap of {"id" -> id,  "produit" -> ¿Produit? }
            return new HashMap<String, Object>() {
                {
                    put("id", id);
                    put("produit", Produit.getById((long) id));
                }
            };
        }
        ).forEach(hmap -> {
            // Get the Produit. Maybe there is no product, so it's Optional.
            Optional<Produit> produit = (Optional<Produit>) hmap.get("produit");
            int id = (int) hmap.get("id");  // get the id too

            if (produit.isPresent()) {
                produits.add(produit.get());
            } else {
                notFound.add(id);
            }

            // Now we know which ones are found and which ones aren't.
        });

        // on met notre liste dans un message de l'api
        ResultatRecherche rr = new ResultatRecherche();
        rr.produitList = produits.stream().map(Produit::toApiProduit).collect(Collectors.toList());
        rr.Session = r.session;

        // on envoit le message
        this.envoyerMessage(rr);
    }

    /**
     * Envoi le message aux agents
     *
     * @param s l'objet de l'api à envoyer
     */
    private void envoyerMessage(Serializable s) {
        try {
            // création du message pour JADE
            ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
            msg.addReceiver(new AID("client", AID.ISLOCALNAME));
            msg.setContentObject(s);

            // envoit du message
            this.getAgent().send(msg);

        } catch (IOException ex) {
            Logger.getLogger(ClientBehavior.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }
}
