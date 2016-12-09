
package fr.miage.supermarche.persist;

import java.util.HashMap;
import java.util.Iterator;


public class RequetesInternesLauncher {
    
    public static void testRetirerProduits() {
        HashMap<Integer, Integer> mapProduits = new HashMap<>();
        mapProduits.put(770584450, 2);
        mapProduits.put(771269767, 2);
        
        HashMap<Integer, Boolean> mapResults = RequetesInternes.retirerProduits(mapProduits);
        Iterator<Integer> itResults = mapResults.keySet().iterator();
        while (itResults.hasNext()) {
            Integer idProduit = itResults.next();
            Boolean result = mapResults.get(idProduit);
            
            System.out.println(idProduit + " => " + result);
        }
    }
    
    public static void main(String[] args) {
        testRetirerProduits();
    }
}
