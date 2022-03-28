package me.fayorg.ottoman;

import me.fayorg.ottoman.commands.Handler;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class DiscordEventsHandler extends ListenerAdapter {

    private final Handler handler = new Handler();

    @Override
    public void onReady(@NotNull ReadyEvent event) {
        handler.loadCommands();
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if(event.getChannelType().isGuild()) {
            handler.handleGuildMessage(event.getGuild(), event.getTextChannel(), event.getAuthor(), event.getMessage());
            return;
        }
        if(event.getChannelType().isMessage()) {
            handler.handlePrivateMessage();
            return;
        }
    }
}
