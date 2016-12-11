package fr.miage.supermarche.agent;

import fr.miage.supermarche.behavior.ClientBehavior;
import fr.miage.supermarche.behavior.FournisseurBehavior;
import fr.miage.supermarche.behavior.SupermarcheBehavior;
import fr.miage.supermarche.util.AchatFournisseur;
import fr.miage.supermarche.util.Periode;
import fr.miage.supermarche.util.PeriodeType;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.DFService;
import jade.domain.FIPAException;
import fr.miage.supermarche.util.Stock;
import fr.miage.supermarche.util.Tarification;
import fr.miage.supermarche.util.strategy.AchatFournisseurSimpleStrategy;
import fr.miage.supermarche.util.strategy.PeriodeSimpleStrategy;
import fr.miage.supermarche.util.strategy.StockSimpleStrategy;
import fr.miage.supermarche.util.strategy.TarificationALaDemandeStrategy;
import fr.miage.supermarche.util.strategy.TarificationSimpleStrategy;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Antoine NOSAL
 * @author Maxime BLAISE
 * @author Guillaume DÉNISSE
 * @author Geoffrey GAILLARD
 */
public class Supermarche extends Agent {

    protected void setup() {
        System.out.println("\n[SUPERMARCHE] Lancement de '" + this.getLocalName() + "'");

        /**
         * Enregistrement l'agent dans les pages jaunes
         */
        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(getAID());
        ServiceDescription sd = new ServiceDescription();
        sd.setType("supermarche");
        sd.setName(this.getLocalName());
        dfd.addServices(sd);
        try {
            DFService.register(this, dfd);
        } catch (FIPAException fe) {
            fe.printStackTrace();
        }
        
        /**
         * Définition des stratégies
         */
        Stock stock = new Stock();
        stock.setStrategy(new StockSimpleStrategy(0.50));
        Periode periode = new Periode(null, null, PeriodeType.STANDARD);
        periode.setStrategy(new PeriodeSimpleStrategy());
        Tarification tarification = new Tarification();
        tarification.setStrategy(new TarificationALaDemandeStrategy());
        AchatFournisseur af = new AchatFournisseur();
        af.setStrategy(new AchatFournisseurSimpleStrategy());
        
        /**
         * Instanciation des behaviors
         */
        ClientBehavior client = new ClientBehavior(this);
        FournisseurBehavior fournisseur = new FournisseurBehavior(this, af, stock);
        SupermarcheBehavior supermarche = new SupermarcheBehavior(this, 20000, stock, periode, tarification);
        
        List<Behaviour> behaviors = Arrays.asList(fournisseur, client, supermarche);
        
        behaviors.forEach(it -> addBehaviour(it));
    }

}
