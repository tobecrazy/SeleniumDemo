package main.java.com.dbyl.tests;

import java.io.UnsupportedEncodingException;
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
		ResultSet result = state.executeQuery("select * from luohe");
		while (result.next()) {
			System.out.println(unicodeToChinese(result.getString(2)));
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		try {
			Date d = new Date(sdf.parse("2017/6/16").getTime());
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		Date date = new Date(System.currentTimeMillis());
		PreparedStatement ps = conn.prepareStatement("INSERT into luohe(name,price,cdate) values (?, ?, ?)");

		for (int n = 0; n < 1; n++) {
			String name = "中文测试Test";
			name = chineseToUnicode(name);
			ps.setString(1, name);
			ps.setFloat(2, 123.1f);

			ps.setDate(3, date);
			ps.addBatch();
		}
		ps.executeBatch();
	}

	/**
	 * @author young
	 * @param str
	 * @return
	 */
	private static String chineseToUnicode(String str) {
		char[] chars = str.toCharArray();
		String returnStr = "";
		for (int i = 0; i < chars.length; i++) {
			returnStr += "\\u" + Integer.toString(chars[i], 16);
		}
		return returnStr;
	}

	/**
	 * @author young
	 * @param unicode
	 * @return
	 */
	private static String unicodeToChinese(String unicode) {
		String[] strs = unicode.split("\\\\u");
		String returnStr = "";
		for (int i = 1; i < strs.length; i++) {
			returnStr += (char) Integer.valueOf(strs[i], 16).intValue();
		}
		return returnStr;
	}
}
