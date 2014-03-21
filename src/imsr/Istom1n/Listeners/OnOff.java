package imsr.Istom1n.Listeners;

import java.util.Date;
import imsr.Istom1n.DB.Maps;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class OnOff implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Maps.getTimeOnLogin().put(event.getPlayer().getName(), new Date().getTime());
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		long timeInGame = (new Date().getTime()) - Maps.getTimeOnLogin().get(event.getPlayer().getName());
		Maps.getTimeInGame().put(event.getPlayer().getName(), timeInGame);
	}	

}
