package imsr.Istom1n.DB;

import java.util.HashMap;

public class Maps {

	private static HashMap<String, Long> timeOnLogin = new HashMap<String, Long>();
	private static HashMap<String, Long> timeInGame = new HashMap<String, Long>();
	
	public void setTimeOnLogin(HashMap<String, Long> timeOnLogin) {
		this.timeOnLogin = timeOnLogin;
	}
	
	public void setTimeInGame(HashMap<String, Long> timeInGame) {
		this.timeInGame = timeInGame;
	}
	
	public HashMap<String, Long> getTimeOnLogin() {
		return timeOnLogin;
	}
	
	public HashMap<String, Long> getTimeInGame() {
		return timeInGame;
	}
	
}
