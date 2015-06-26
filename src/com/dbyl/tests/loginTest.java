package com.dbyl.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dbyl.libarary.action.ViewHomePage;
import com.dbyl.libarary.pageAction.HomePage;
import com.dbyl.libarary.utils.DriverFactory;
import com.dbyl.libarary.utils.RemoteBrowserBean;
import com.dbyl.libarary.utils.UITest;

public class loginTest extends UITest {

	RemoteBrowserBean remotebrowser = new RemoteBrowserBean("chrome",
			"http://192.168.1.107:4444/wd/hub");
	WebDriver driver = DriverFactory.getRemoteDriver(new RemoteBrowserBean(
			"chrome"));

	@BeforeMethod(alwaysRun = true)
	public void init() {

		super.init(driver);
		ViewHomePage.setDriver(driver);
		// CommonLogin.setDriver(driver);
	}

	@Test(groups = "loginTest")
	public void loginByUerName() throws Exception {
		// CommonLogin.login("seleniumcookies@126.com","cookies123");
		ViewHomePage.viewMyProfile();
	}

	@AfterMethod(alwaysRun = true)
	public void stop() {
		super.stop();
	}

}
