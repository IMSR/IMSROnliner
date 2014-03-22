package imsr.Istom1n;

import java.util.logging.Level;

import org.bukkit.plugin.Plugin;

public class Config {
	
	public static String login = "root";
	public static String password = "";
	public static String host = "localhost";
	public static String database = "IMSROnliner";

	public static void load(IMSROnliner plugin) {
		loadConfig(plugin);
	}

	public static void loadConfig(Plugin plugin) {
		try {
			Config.login = plugin.getConfig().getString("MySQL.Login");
			Config.password = plugin.getConfig().getString("MySQL.Password");
			Config.host = plugin.getConfig().getString("MySQL.Host");
			Config.database = plugin.getConfig().getString("MySQL.Database");
		} catch (Exception e) {
			plugin.getLogger().log(Level.WARNING, "Ошибка загрузки конфига, используются стандартные значения.");
		}
	}
	
}
