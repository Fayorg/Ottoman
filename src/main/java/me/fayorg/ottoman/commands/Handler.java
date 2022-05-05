package me.fayorg.ottoman.commands;

import me.fayorg.ottoman.Ottoman;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;

public class Handler {

    public static ArrayList<AbstractCommand> commands = new ArrayList<AbstractCommand>();

    public void handleGuildMessage(Guild guild, TextChannel textChannel, @NotNull User author, Message message) {
        //long start = System.currentTimeMillis();
        if(author.isBot()) return;
        if(!isCommand(message)) return;
        String requestedCommand = message.getContentRaw().trim().split(" ")[0].replace(Ottoman.PREFIX, "").toLowerCase();
        for(AbstractCommand command : commands) {
            if(!requestedCommand.equalsIgnoreCase(command.getCommand()) && Arrays.stream(command.getAliases()).noneMatch(requestedCommand::equalsIgnoreCase)) continue;
            if(!checkCommandAvailability(command)) {
                message.reply("This command is currently unavailable!").queue();
                return;
            }
            command.execute(message, textChannel, author);
            return;
            //System.out.println("[i] Process duration: " + (System.currentTimeMillis() - start) + " ms");
        }
    }

    public void handlePrivateMessage() {

    }

    public void loadCommands() {
        commands.add(new CommandPing());
        commands.add(new CommandPI());
        commands.add(new CommandRandom());
        commands.add(new CommandGithub());
    }

    private boolean isCommand(@NotNull Message message) {
        // TODO Implement the custom prefix for each guild (Need SQL integration first).
        return message.getContentRaw().startsWith(Ottoman.PREFIX);
    }

    private boolean checkCommandAvailability(@NotNull AbstractCommand command) {
        // TODO Implement the check if the user is an Admin (Need SQL integration first).
        return command.isEnabled().equals(CommandEnabled.ENABLED);
    }

    /*

        COMMAND IDEAS :

            - Command that generate multiple math symbols ready to be copy-past

     */

}
