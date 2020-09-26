package fr.umontpellier.iut.commandes;

import net.dv8tion.jda.api.entities.Message;

/**
 * Commande Help
 * 
 * @see Commande
 * 
 * @version 1.0
 */
public class Help implements Commande {

    @Override
    public void execute(Message messageRecue) {
        String reponse = " La demande d'aide a été entendue.";
        messageRecue.getChannel().sendMessage(reponse).queue();
    }

}
