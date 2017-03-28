package main.java.com.dbyl.tests;

import main.java.com.dbyl.libarary.utils.DriverFlags;
import main.java.com.dbyl.libarary.utils.Context.BrowserType;

public class BuilderTest {

	public static void main(String[] args) {
		DriverFlags driver = new DriverFlags.Builder().setBrowserTyp(BrowserType.chrome).setHost("1111").build();
		System.out.println(driver.getHost() + driver.getBrowserType());

	}

}
