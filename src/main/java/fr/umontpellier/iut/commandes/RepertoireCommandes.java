package fr.umontpellier.iut.commandes;

import java.util.HashMap;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

/**
 * <b>RepertoireCommandes est la classe qui répertorie toutes les commandes du
 * bot.</b>
 * <p>
 * Elle est caractérisée par :
 * <ul>
 * <li>Une HashMap qui relie le mot clé à la commande executé</li>
 * </ul>
 * </p>
 * <p>
 *  Le repertoire est automatiquement initialisé en static. 
 * </p>
 * 
 * @see HashMap
 * @see Commande
 * 
 * @version 1.0
 */
public class RepertoireCommandes {

    /**
     * Répertoire des commandes. Cet repertoire relie le mot clé à une commande.
     * 
     * @see HashMap
     * @see Commande
     */
    private static final HashMap<String, Commande> REPERTOIRE_COMMANDES = new HashMap<>();

    static {
        REPERTOIRE_COMMANDES.put("help", new Help());
    }

    /**
     * 
     * Retourne la commande associée au mot clef contenue dans le message
     * 
     * @param motClef
     * @return {@code Commande} 
     * @see java.util.HashMap#get(java.lang.Object)
     */
    public static Commande getCommande(MessageReceivedEvent msg) {
        String motClef = getMotClefDansMessage(msg);
        return REPERTOIRE_COMMANDES.get(motClef);
    }


    /**
     * Retourne le mot clef du message.
     * 
     * @return {@code String}.
     * 
     * @see String
     */
    private static String getMotClefDansMessage(MessageReceivedEvent msg) {
        return msg.getMessage().getContentRaw().substring(1).split(" ")[0].toLowerCase();
    }

    private RepertoireCommandes() {
        throw new IllegalStateException("Utility class");
    }

}