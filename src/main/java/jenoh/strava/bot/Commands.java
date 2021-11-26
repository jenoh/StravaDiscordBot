package jenoh.strava.bot;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

        if(args[0].equalsIgnoreCase(BotApplication.getConfigManager().getToml().getString("bot.prefix") +"info")) {
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage("Info WIP").queue();
        }

        if(args[0].equalsIgnoreCase(BotApplication.getConfigManager().getToml().getString("bot.prefix") +"alias")) {
            event.getChannel().sendTyping().queue();
            if (args.length == 3) {
                event.getChannel().sendMessage(args[1]+ " / " + args[2]).queue();
            } else {
                event.getChannel().sendMessage("missing arguments").queue();
            }
        }
    }
}
