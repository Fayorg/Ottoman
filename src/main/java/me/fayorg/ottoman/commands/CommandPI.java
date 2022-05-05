package me.fayorg.ottoman.commands;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;

public class CommandPI extends AbstractCommand {


    @Override
    public String getDescription() {
        return "Get some digits of PI";
    }

    @Override
    public String getCommand() {
        return "pi";
    }

    @Override
    public String getUsage() {
        return "pi [digits]";
    }

    @Override
    public CommandEnabled isEnabled() {
        return isCommandEnabledInDatabase() ? CommandEnabled.ENABLED : CommandEnabled.DISABLED;
    }

    @Override
    public String[] getAliases() {
        return new String[] {"pie"};
    }

    @Override
    public void execute(Message message, TextChannel channel, User author) {
        message.reply("Here is some digits of PI :" + Math.PI + " !").queue();
    }
}
