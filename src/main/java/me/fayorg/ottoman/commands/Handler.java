package me.fayorg.ottoman.commands;

import me.fayorg.ottoman.Ottoman;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;

import java.util.HashMap;

public class Handler {

    public static HashMap<String, AbstractCommand> commands = new HashMap<String, AbstractCommand>();

    public void handleGuildMessage(Guild guild, TextChannel textChannel, User author, Message message) {
        if(author.isBot() || author == null) return;
        if(!isCommand(message)) return;

    }

    public void handlePrivateMessage() {

    }

    public void loadCommands() {

    }

    private boolean isCommand(Message message) {
        return message.getContentRaw().startsWith(Ottoman.PREFIX) ? true : false;
    }

}
