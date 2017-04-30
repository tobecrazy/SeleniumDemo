package main.java.com.dbyl.tests;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Connection;

import main.java.com.dbyl.libarary.utils.DatabaseUtils;

public class DBTest {

	@Test(groups = { "bdbTest" })
	public void dbTest() throws ClassNotFoundException, SQLException {
		Connection conn = (new DatabaseUtils.Builder().setHost("WWW.WP.COM").setDbName("study").setUser("study")
				.setPassword("123456").builder()).getConection();
		Statement state = conn.createStatement();
		ResultSet result = state.executeQuery("show databases");
		while (result.next()) {
			System.out.println(result.getString(1));
		}
	}

}
