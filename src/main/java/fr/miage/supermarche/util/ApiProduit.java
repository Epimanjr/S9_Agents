package fr.miage.supermarche.util;


import fr.miage.agents.api.model.Produit;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by geoffrey on 10/12/2016.
 */
public class ApiProduit extends Produit {
    public Produit toRawApiProduit(){
        return (Produit) this;
    }

    public static List<Produit> toRawApiProduitList(List<ApiProduit> ps){
        return ps.stream().map(p -> (Produit) p).collect(Collectors.toList());
    }
}
