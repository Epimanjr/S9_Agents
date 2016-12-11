package fr.miage.supermarche.util;

import java.io.Serializable;
import java.util.Map;

/**
 *
 * @author Antoine NOSAL
 */
public class MessageInterne implements Serializable {

    public MessageInterneType type;
    
    /**
     * Utile si type = demandeReapprov
     */
    public Map<Long, Integer> aCommander;

    public MessageInterne(MessageInterneType type) {
        this.type = type;
    }
}
