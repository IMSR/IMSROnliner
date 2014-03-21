package imsr.Istom1n.DB;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map.Entry;
import java.util.logging.Logger;

import org.bukkit.Bukkit;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

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
			connection = (Connection) DriverManager.getConnection(host, login, password);
			log.info("[IMSROnliner] Connected to mysql server, creating database if not exists");
			Statement st = (Statement) connection.createStatement();
			
			st.executeUpdate("CREATE DATABASE IF NOT EXISTS "
						+ database);
				
			st.executeUpdate("CREATE TABLE IF NOT EXISTS IMSROnliner"
					+ "("
					+ "keyint int unsigned not null auto_increment primary key,"
					+ "playername varchar(255)," + "timeInGame int," + ");");
			
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
			connection = (Connection) DriverManager.getConnection(host, login, password);
			Statement st = (Statement) connection.createStatement();
			
			for (Entry<String, Long> time : Maps.getTimeInGame().entrySet()) {
				//Добавление пользователя не присутствующего в таблице
				st.executeUpdate("UPDATE IMSROnliner SET time = " + time.getValue() + " WHERE playername = " + time.getKey() + ";"); 
			}
			
			st.close();
			log.info("[IMSROnliner] Upload on MySQL complete.");
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
