package imsr.Istom1n;

import imsr.Istom1n.Commands.IMSROnlinerCommand;
import imsr.Istom1n.DB.Maps;
import imsr.Istom1n.Listeners.OnOff;

import org.bukkit.plugin.java.JavaPlugin;

public class IMSROnliner extends JavaPlugin {
	
	private Maps db;
	
	@Override
	public void onEnable() {
		getLogger().info("IMSROnliner v" + getDescription().getVersion() + " is Enabled");
		
		
		db = new Maps();
		
		getServer().getPluginManager().registerEvents(new OnOff(db), this);
		getCommand("imsronliner").setExecutor(new IMSROnlinerCommand());
	}
	
	@Override
	public void onDisable() {
		getLogger().info("IMSROnliner v" + getDescription().getVersion() + " is Disabled");
	}
	
}
