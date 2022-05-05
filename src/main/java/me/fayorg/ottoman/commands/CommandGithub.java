package me.fayorg.ottoman.commands;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;

public class CommandGithub extends AbstractCommand {

    @Override
    public String getDescription() {
        return "Get the github link of Ottoman!";
    }

    @Override
    public String getCommand() {
        return "github";
    }

    @Override
    public String getUsage() {
        return "github";
    }

    @Override
    public String[] getAliases() {
        return new String[] {"git"};
    }

    @Override
    public void execute(Message message, TextChannel channel, User author) {
        message.reply("\uD83D\uDCAB Checkout my github page at this link : https://github.com/Fayorg/Ottoman !").queue();
    }
}
