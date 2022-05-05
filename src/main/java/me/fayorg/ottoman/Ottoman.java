package me.fayorg.ottoman;

import me.fayorg.ottoman.utils.Database;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;
import java.sql.SQLException;

public class Ottoman {

   public static JDA jda;
   public static Database database;

   public static final String PREFIX = "?";

    public static void main(String[] args) {

        try {
            // ALL JDA STUFF (PREINIT)
            jda = JDABuilder.createDefault(args[0]).build();
            jda.getPresence().setPresence(OnlineStatus.DO_NOT_DISTURB, Activity.watching("Fayorg adding more function!"));
            jda.addEventListener(new DiscordEventsHandler());

            // ALL OTHER STUFF (NON-CRITICAL) (POSTINIT)
            database = new Database(args[1], args[2]);
            if(database.isConnected()) {
                System.out.println("[i] Database connection established!");
            } else {
                System.out.println("[i] Database connection not established!");
            }


        } catch (LoginException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("[e] Can't create ConnectionPool with the database!");
        }

    }

}
