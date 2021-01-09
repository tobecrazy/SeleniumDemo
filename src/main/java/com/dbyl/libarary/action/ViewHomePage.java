/**
 * 
 */
package com.dbyl.libarary.action;

import org.openqa.selenium.WebDriver;

import com.dbyl.libarary.pageAction.HomePage;

/**
 * @author Young
 *
 */
public class ViewHomePage {

	private static WebDriver driver;
	private static HomePage homePage;

	public static WebDriver getDriver() {
		return driver;
	}

	public static HomePage viewMyProfile() throws Exception {

		CommonLogin.setDriver(driver);
		homePage = CommonLogin.login();
		homePage.clickOnMainPage();
		return homePage;
	}

	public static void setDriver(WebDriver driver) {
		ViewHomePage.driver = driver;
	}

}
