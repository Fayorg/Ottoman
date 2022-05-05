package me.fayorg.ottoman.commands;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;

import java.util.Random;

public class CommandRandom extends AbstractCommand {


    private Random random = new Random();

    @Override
    public String getDescription() {
        return "Get a random number";
    }

    @Override
    public CommandEnabled isEnabled() {
        return isCommandEnabledInDatabase() ? CommandEnabled.ENABLED : CommandEnabled.DISABLED;
    }

    @Override
    public String getCommand() {
        return "random";
    }

    @Override
    public String getUsage() {
        return "random [<min> <max>]";
    }

    @Override
    public String[] getAliases() {
        return new String[] {"r", "ran", "rand"};
    }

    @Override
    public void execute(Message message, TextChannel channel, User author) {
        if(message.getContentRaw().split(" ").length <= 3) {
            try {
                if (message.getContentRaw().split(" ").length == 3) {
                    int max = Integer.parseInt(message.getContentRaw().split(" ")[2]);
                    int min = Integer.parseInt(message.getContentRaw().split(" ")[1]);

                    message.reply("Your random number is " + (random.nextInt(max + 1 - min) + min)).queue();
                    return;
                }
            } catch (NumberFormatException e) {
                message.reply("Your random number is " + random.nextInt()).queue();
                return;
            }
            message.reply("Your random number is " + random.nextInt()).queue();
        }
    }
}
