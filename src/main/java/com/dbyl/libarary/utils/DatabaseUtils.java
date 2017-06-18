package main.java.com.dbyl.libarary.utils;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author young
 * 
 */
import com.mysql.jdbc.Connection;
/**
 * @version 1.0
 * @author young
 *
 */
public class DatabaseUtils {
	private String host;
	private String user;
	private String password;
	private int port;
	private String dbName;
	private static Connection connection;

	/**
	 * @author young
	 * @param builder
	 */
	public DatabaseUtils(Builder builder) {
		this.host = builder.getHost();
		this.port = builder.getPort();
		this.dbName = builder.getDbName();
		this.user = builder.getUser();
		this.password = builder.getPassword();

	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getHost() {
		return host;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

	public int getPort() {
		return port;
	}

	/**
	 * Default Connection Set Default DD info
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Connection getConection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		if (getHost() == null) {
			setHost("127.0.0.1");
		}
		if (getPort() == 0) {
			setPort(3306);
		}
		if (getDbName() == null) {
			setDbName("mysql");
		}
		if (getUser() == null) {
			setUser("root");
		}
		if (getPassword() == null) {
			setPassword("");
		}

		String url = "jdbc:mysql://" + getHost() + ":" + getPort() + "/" + getDbName()+"?useUnicode=true&amp;characterEncoding=utf-8";
		System.out.println(url);
		connection = (Connection) DriverManager.getConnection(url, getUser(), getPassword());
		return connection;
	}

	public static class Builder {
		private String host;
		private String user;
		private String password;
		private int port;
		private String dbName;

		public String getHost() {
			return host;
		}

		public Builder setHost(String host) {
			this.host = host;
			return this;
		}

		public String getUser() {
			return user;
		}

		public Builder setUser(String user) {
			this.user = user;
			return this;
		}

		public String getPassword() {
			return password;
		}

		public Builder setPassword(String password) {
			this.password = password;
			return this;
		}

		public int getPort() {
			return port;
		}

		public Builder setPort(int port) {
			this.port = port;
			return this;
		}

		public String getDbName() {
			return dbName;
		}

		public Builder setDbName(String dbName) {
			this.dbName = dbName;
			return this;
		}

		/**
		 * @author young
		 * @return
		 */
		public DatabaseUtils builder() {
			return new DatabaseUtils(this);

		}

	}

}
