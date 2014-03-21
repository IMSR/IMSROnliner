package imsr.Istom1n;

import imsr.Istom1n.Commands.IMSROnlinerCommand;
import imsr.Istom1n.DB.MySQL;
import imsr.Istom1n.Listeners.OnOff;

import org.bukkit.plugin.java.JavaPlugin;

public class IMSROnliner extends JavaPlugin {
	
	private static MySQL mysql;
	
	@Override
	public void onEnable() {
		Config.load(this);

		mysql = new MySQL(Config.login, Config.password, Config.host, Config.database);
		mysql.createNeeded();
		
		getServer().getPluginManager().registerEvents(new OnOff(), this);
		getCommand("imsronliner").setExecutor(new IMSROnlinerCommand());
		
		getLogger().info("IMSROnliner v" + getDescription().getVersion() + " is Enabled");
	}
	
	@Override
	public void onDisable() {
		mysql.backupMySQL();
		getLogger().info("IMSROnliner v" + getDescription().getVersion() + " is Disabled");
	}
	
	public static MySQL getMySQL() {
		return mysql;
	}
	
}
