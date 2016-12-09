package fr.miage.supermarche.persist;

/**
 *
 * @author Maxime BLAISE
 */
public enum TypeTransaction {
    ACHAT("achat"),
    VENTE("vente");

    private String type;

    private TypeTransaction(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
