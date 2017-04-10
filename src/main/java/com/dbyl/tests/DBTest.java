package main.java.com.dbyl.tests;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

import main.java.com.dbyl.libarary.utils.DatabaseUtils;

public class DBTest {

	public DBTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection conn = DatabaseUtils.getConection();
		Statement state = conn.createStatement();
		ResultSet result = state.executeQuery("show databases");
		while (result.next()) {
			System.out.println(result.getString(1));
		}
	}

}
