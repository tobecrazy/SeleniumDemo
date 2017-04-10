package main.java.com.dbyl.libarary.utils;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author young
 * 
 */
import com.mysql.jdbc.Connection;

public class DatabaseUtils {
	private static String host = "www.wp.com";
	private static String user="study";
	private static String password="123456";
	private static int port = 3306;
	private static String dbName = "study";
	private static Connection connection;
	public void setHost(String host) {
		this.host = host;
	}

	public void setPort(int port) {
		this.port = port;
	}

	/**
	 * Default Connection
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
		connection = (Connection) DriverManager.getConnection(url, user, password);
		return connection;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
