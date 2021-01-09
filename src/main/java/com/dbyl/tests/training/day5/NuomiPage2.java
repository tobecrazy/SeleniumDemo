package com.dbyl.tests.training.day5;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class NuomiPage2 extends BasePage {

	public WebDriver driver;

	protected NuomiPage2(WebDriver driver) throws Exception {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	Locator login = new Locator("login");

	/**
	 * Login
	 */
	public void verifyLoginPresent() {
		super.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		Assert.assertEquals("登录", getText(login));
	}
}
