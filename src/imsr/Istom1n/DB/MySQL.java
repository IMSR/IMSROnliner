package imsr.Istom1n.DB;

import java.sql.*;
import java.util.Map.Entry;
import java.util.logging.Logger;

import org.bukkit.Bukkit;

public class MySQL {

	private String login, password, host, database;

	private Logger log = Bukkit.getLogger();
	
	public MySQL(String login, String password, String host, String database) {
		this.login = login;
		this.password = password;
		this.host = host;
		this.database = database;
	}
	
	public void createNeeded() {
		Connection connection = null;
		try {
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://" + host + "/" + database, login, password);
			log.info("[IMSROnliner] Connected to mysql server, creating database if not exists");
			Statement st = (Statement) connection.createStatement();
			
			st.executeUpdate("CREATE DATABASE IF NOT EXISTS IMSROnliner");
				
			st.executeUpdate("CREATE TABLE IF NOT EXISTS IMSROnliner"
					+ "("
					+ "id int unsigned not null auto_increment primary key,"
					+ "playername varchar(255)," + "timeInGame int" + ");");
			
			st.close();
			log.info("[IMSROnliner] Connected to mysql server and database");
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void backupMySQL() {
		Connection connection = null;
		try {
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://" + host + "/" + database, login, password);
			Statement st = (Statement) connection.createStatement();
			
			for (Entry<String, Integer> time : Maps.getTimeInGame().entrySet()) {
				//TODO Добавление пользователя не присутствующего в таблице
				st.executeUpdate("INSERT INTO IMSROnliner (playername, timeInGame) VALUES('" + time.getKey() + "', " + time.getValue() + ");"); 
			}
			
			st.close();
			log.info("[IMSROnliner] Upload on MySQL complete.");
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
