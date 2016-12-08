package fr.miage.supermarche.util;

import java.io.Serializable;

/**
 *
 * @author Antoine NOSAL
 */
public class MessageInterne implements Serializable {

    public MessageInterneType type;

    public MessageInterne(MessageInterneType type) {
        this.type = type;
    }
}
