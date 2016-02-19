package com.dbyl.libarary.pageAction;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.dbyl.libarary.utils.BasePage;
import com.dbyl.libarary.utils.Locator;

public class LoginPage extends BasePage {

	WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public LoginPage(WebDriver driver) throws Exception {
		super(driver);
		driver.get("http://www.zhihu.com/#signin");
	}

	Locator loginEmailInputBox = new Locator("loginEmailInputBox",30);

	Locator loginPasswordInputBox = new Locator("loginPasswordInputBox");
	Locator loginButton = new Locator("loginButton");
	Locator profile = new Locator(
			"profile");

	public void typeEmailInputBox(String email) throws Exception {
		open("http://www.zhihu.com");
		switchToLogin();
		type(loginEmailInputBox, email);
	}

	public void typePasswordInputBox(String password) throws Exception {
		type(loginPasswordInputBox, password);
	}

	public void clickOnLoginButton() throws Exception {
		click(loginButton);
	}

	public boolean isPrestentProfile() throws IOException {
		return isElementPresent(profile, 20);

	}

	public void waitForPageLoad() {
		super.getDriver().manage().timeouts()
				.pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	public void switchToLogin() throws Exception
	{
		Locator clickToLoginButton=new Locator("clickToLoginButton");
		click(clickToLoginButton);
	}
	
}
