package jenoh.StravaDiscordBot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.security.auth.login.LoginException;
import java.io.File;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import jenoh.StravaDiscordBot.utils.ConfigManager;

@SpringBootApplication
public class StravaDiscordBotApplication {

	private static ConfigManager configManager;
	public static JDA jda;

	public static void main(String[] args) throws LoginException {
		/* Starting the REST API */
		SpringApplication.run(StravaDiscordBotApplication.class, args);

		/* Initialize the discord bot */
		configManager = new ConfigManager(new File(System.getProperty("user.dir"), "config.toml"));
		jda = JDABuilder.createDefault(configManager.getToml().getString("bot.token")).build();
		jda.getPresence().setStatus(OnlineStatus.DO_NOT_DISTURB);
		jda.addEventListener(new Commands());
	}
	public static ConfigManager getConfigManager() {
		return configManager;
	}


}
