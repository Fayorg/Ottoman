package me.fayorg.ottoman.commands;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;

public class CommandPing extends AbstractCommand {
    @Override
    public String getDescription() {
        return "Get Ottoman current ping!";
    }

    @Override
    public String getCommand() {
        return "ping";
    }

    @Override
    public String getUsage() {
        return "ping";
    }

    @Override
    public String[] getAliases() {
        return new String[] {"ms", "bot"};
    }

    @Override
    public void execute(Message message, TextChannel channel, User author) {
        message.reply("Ping command executed!").queue();
    }
}
