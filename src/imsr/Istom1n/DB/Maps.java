package imsr.Istom1n.DB;

import java.util.HashMap;

public class Maps {

	public static HashMap<String, Long> timeOnLogin = new HashMap<String, Long>();
	public static HashMap<String, Long> timeInGame = new HashMap<String, Long>();
	
	public void setTimeOnLogin(HashMap<String, Long> timeOnLogin) {
		Maps.timeOnLogin = timeOnLogin;
	}
	
	public void setTimeInGame(HashMap<String, Long> timeInGame) {
		Maps.timeInGame = timeInGame;
	}
	
	public static HashMap<String, Long> getTimeOnLogin() {
		return timeOnLogin;
	}
	
	public static HashMap<String, Long> getTimeInGame() {
		return timeInGame;
	}
	
}
