package me.fayorg.ottoman;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Ottoman {

   public static JDA jda;

   public static final String PREFIX = "?";

    public static void main(String[] args) {

        try {
            // ALL JDA STUFF (PREINIT)
            jda = JDABuilder.createDefault(args[0]).build();
            jda.getPresence().setPresence(OnlineStatus.DO_NOT_DISTURB, Activity.watching("Fayorg adding more function!"));
            jda.addEventListener(new DiscordEventsHandler());

            // ALL OTHER STUFF (NON-CRITICAL) (POSTINIT)



        } catch (LoginException e) {
            e.printStackTrace();
        }

    }

}
