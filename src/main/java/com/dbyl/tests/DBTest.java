package main.java.com.dbyl.tests;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.testng.annotations.Test;

import com.mysql.jdbc.Connection;

import main.java.com.dbyl.libarary.utils.DatabaseUtils;

public class DBTest {

	@Test(groups = { "bdbTest" })
	public void dbTest() throws ClassNotFoundException, SQLException {
		Connection conn = (new DatabaseUtils.Builder().setHost("WWW.WP.COM").setDbName("study").setUser("study")
				.setPassword("123456").builder()).getConection();
		Statement state = conn.createStatement();
		ResultSet result = state.executeQuery("desc luohe");
		while (result.next()) {
			System.out.println(result.getString(1));
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		try {
			Date d= new Date( sdf.parse("2017/6/16").getTime());
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		Date date = new Date(System.currentTimeMillis());
		PreparedStatement ps = conn.prepareStatement("INSERT into luohe(name,price,cdate) values (?, ?, ?)");
		for (int n = 0; n < 1000; n++) {
			ps.setString(1, "123wasads");
			ps.setFloat(2, 123.1f);

			ps.setDate(3, date);
			ps.addBatch();
		}
		ps.executeBatch();
	}

}
