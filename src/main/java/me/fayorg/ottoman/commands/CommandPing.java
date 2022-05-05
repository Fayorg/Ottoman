package me.fayorg.ottoman.commands;

import me.fayorg.ottoman.Ottoman;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;

import java.sql.ResultSet;
import java.sql.SQLException;

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
    public CommandEnabled isEnabled() {
        try {
            ResultSet res = Ottoman.database.query("SELECT * FROM Commands WHERE Name='" + getCommand() + "'");
            res.first();
            return (res.getBoolean(2)) ? CommandEnabled.ENABLED : CommandEnabled.DISABLED;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return CommandEnabled.DISABLED;
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
        long start = System.currentTimeMillis();
        message.reply("Calculating...").queue((msg) -> {
            long ping = System.currentTimeMillis() - start;
            msg.editMessage(((ping >= 500) ? "\uD83D\uDD34 " : "\uD83D\uDFE2 ") + "My current ping is : " + ping + "ms !").queue();
        });
    }
}
