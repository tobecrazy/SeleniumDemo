package com.dbyl.libarary.pageAction;

import org.openqa.selenium.WebDriver;

import com.dbyl.libarary.pageAction.interfaces.ILoginPage;
import com.dbyl.libarary.utils.BasePage;
import com.dbyl.libarary.utils.Locator;
import com.dbyl.libarary.utils.Locator.ByType;

/**
 * This Page is a different Login Page
 * 
 * @author young
 *
 */
public class NewLoginPage extends BasePage implements ILoginPage {

	WebDriver driver;
	Locator loginEmailInputBox = new Locator("//input[@id='email']", 30);

	Locator loginPasswordInputBox = new Locator("input#password", 30, ByType.cssSelector);
	Locator loginButton = new Locator("login", 30, ByType.name);

	public WebDriver getDriver() {
		return driver;
	}

	public NewLoginPage(WebDriver driver) throws Exception {
		super(driver);
		driver.get("https://accounts.douban.com/login");
	}

	@Override
	public void typeUserName(String userName) throws Exception {
		type(loginEmailInputBox, userName);

	}

	@Override
	public void typePassword(String password) throws Exception {
		type(loginPasswordInputBox, password);

	}

	@Override
	public void clickOnLoginButton() throws Exception {
		click(loginButton);

	}

}
