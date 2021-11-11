package jenoh.StravaDiscordBot;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

        if(args[0].equalsIgnoreCase(StravaDiscordBotApplication.getConfigManager().getToml().getString("bot.prefix") +"info")) {
            event.getChannel().sendTyping().queue();
            // Envoyer text informatif sur le bot
            event.getChannel().sendMessage("Oui la farine").queue();
        }

        if(args[0].equalsIgnoreCase(StravaDiscordBotApplication.getConfigManager().getToml().getString("bot.prefix") +"alias")) {
            event.getChannel().sendTyping().queue();
            if (args.length == 3) {
                event.getChannel().sendMessage(args[1]+ " / " + args[2]).queue();
            } else {
                event.getChannel().sendMessage("missing arguments").queue();
            }
        }
    }
}
