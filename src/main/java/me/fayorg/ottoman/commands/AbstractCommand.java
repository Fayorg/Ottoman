package me.fayorg.ottoman.commands;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;

public abstract class AbstractCommand {

    private CommandCategory category = CommandCategory.UNKNOWN;
    private CommandEnabled status = CommandEnabled.ENABLED;

    public AbstractCommand() {

    }

    /**
     * The description will appear when executing the man command or when listing all commands (Do not set the usage here).
     */
    public abstract String getDescription();

    /**
     * Set the name that users will have to use to run the command.
     */
    public abstract String getCommand();

    public abstract String getUsage();

    public abstract String[] getAliases();

    public void setCommandCategory(CommandCategory newCategory) {
        category = newCategory;
    }

    /**
     * This defines if the command is enabled, disabled or admin-only. {@link CommandEnabled}
     */
    public CommandEnabled isEnabled() {
        return this.status;
    }

    /**
     * This will define if the command is hidden from non-admin (bot admin, not guild admin). (NOT IMPLEMENTED)
     */
    public boolean isListed() {
        return true;
    }

    /**
     * Function executed everytime someone run this command.
     * @param message
     * @param channel
     * @param author
     */
    public abstract void execute(Message message, TextChannel channel, User author);

}

