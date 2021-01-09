package com.dbyl.libarary.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The Class DatabaseUtils.
 * 
 * @version 1.0
 * 
 * @author young
 */

public class DatabaseUtils {
	public final String JDBCDRIVER = "com.mysql.cj.jdbc.Driver";

	/** The host. */
	private String host;

	/** The user. */
	private String user;

	/** The password. */
	private String password;

	/** The port. */
	private int port;

	/** The db name. */
	private String dbName;

	/** The connection. */
	private static Connection connection;

	/**
	 * Instantiates a new database utils.
	 *
	 * @author young
	 * @param builder
	 *            the builder
	 */
	public DatabaseUtils(Builder builder) {
		this.host = builder.getHost();
		this.port = builder.getPort();
		this.dbName = builder.getDbName();
		this.user = builder.getUser();
		this.password = builder.getPassword();

	}

	/**
	 * Sets the host.
	 *
	 * @param host
	 *            the new host
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * Sets the port.
	 *
	 * @param port
	 *            the new port
	 */
	public void setPort(int port) {
		this.port = port;
	}

	/**
	 * Sets the user.
	 *
	 * @param user
	 *            the new user
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * Sets the password.
	 *
	 * @param password
	 *            the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the db name.
	 *
	 * @return the db name
	 */
	public String getDbName() {
		return dbName;
	}

	/**
	 * Sets the db name.
	 *
	 * @param dbName
	 *            the new db name
	 */
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	/**
	 * Gets the host.
	 *
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Gets the port.
	 *
	 * @return the port
	 */
	public int getPort() {
		return port;
	}

	/**
	 * Default Connection Set Default DD info.
	 *
	 * @return the conection
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public Connection getConection() throws ClassNotFoundException, SQLException {
		Class.forName(JDBCDRIVER);
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

		String url = "jdbc:mysql://" + getHost() + ":" + getPort() + "/" + getDbName()
				+ "?useUnicode=true&serverTimezone=UTC&useSSL=false";
		System.out.println(url);
		connection = (Connection) DriverManager.getConnection(url, getUser(), getPassword());
		return connection;
	}

	/**
	 * The Class Builder.
	 */
	public static class Builder {

		/** The host. */
		private String host;

		/** The user. */
		private String user;

		/** The password. */
		private String password;

		/** The port. */
		private int port;

		/** The db name. */
		private String dbName;

		/**
		 * Gets the host.
		 *
		 * @return the host
		 */
		public String getHost() {
			return host;
		}

		/**
		 * Sets the host.
		 *
		 * @param host
		 *            the host
		 * @return the builder
		 */
		public Builder setHost(String host) {
			this.host = host;
			return this;
		}

		/**
		 * Gets the user.
		 *
		 * @return the user
		 */
		public String getUser() {
			return user;
		}

		/**
		 * Sets the user.
		 *
		 * @param user
		 *            the user
		 * @return the builder
		 */
		public Builder setUser(String user) {
			this.user = user;
			return this;
		}

		/**
		 * Gets the password.
		 *
		 * @return the password
		 */
		public String getPassword() {
			return password;
		}

		/**
		 * Sets the password.
		 *
		 * @param password
		 *            the password
		 * @return the builder
		 */
		public Builder setPassword(String password) {
			this.password = password;
			return this;
		}

		/**
		 * Gets the port.
		 *
		 * @return the port
		 */
		public int getPort() {
			return port;
		}

		/**
		 * Sets the port.
		 *
		 * @param port
		 *            the port
		 * @return the builder
		 */
		public Builder setPort(int port) {
			this.port = port;
			return this;
		}

		/**
		 * Gets the db name.
		 *
		 * @return the db name
		 */
		public String getDbName() {
			return dbName;
		}

		/**
		 * Sets the db name.
		 *
		 * @param dbName
		 *            the db name
		 * @return the builder
		 */
		public Builder setDbName(String dbName) {
			this.dbName = dbName;
			return this;
		}

		/**
		 * Builder.
		 *
		 * @author young
		 * @return the database utils
		 */
		public DatabaseUtils builder() {
			return new DatabaseUtils(this);

		}

	}

}
