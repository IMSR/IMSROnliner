package imsr.Istom1n.DB;

import java.util.HashMap;

public class Maps {

	private static HashMap<String, Long> timeOnLogin = new HashMap<String, Long>();
	private static HashMap<String, Integer> timeInGame = new HashMap<String, Integer>();
	
	public void setTimeOnLogin(HashMap<String, Long> timeOnLogin) {
		Maps.timeOnLogin = timeOnLogin;
	}
	
	public void setTimeInGame(HashMap<String, Integer> timeInGame) {
		Maps.timeInGame = timeInGame;
	}
	
	public static HashMap<String, Long> getTimeOnLogin() {
		return timeOnLogin;
	}
	
	public static HashMap<String, Integer> getTimeInGame() {
		return timeInGame;
	}
	
}
