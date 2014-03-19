package imsr.Istom1n;

import imsr.Istom1n.Commands.IMSROnlinerCommand;
import imsr.Istom1n.DB.Maps;
import imsr.Istom1n.Listeners.OnOff;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public class IMSROnliner extends JavaPlugin {
	
	private Maps db;
	private CommandExecutor cmdex = new IMSROnlinerCommand();
	
	@Override
	public void onEnable() {
		getLogger().info("IMSROnliner v" + getDescription().getVersion() + " is Enabled");
		Config.load(this);
		db = new Maps();
		
		getServer().getPluginManager().registerEvents(new OnOff(db), this);
		getCommand("imsronliner").setExecutor(cmdex);
	}
	
	@Override
	public void onDisable() {
		new Utils().backupMySQL();
		getLogger().info("IMSROnliner v" + getDescription().getVersion() + " is Disabled");
	}
	
}
