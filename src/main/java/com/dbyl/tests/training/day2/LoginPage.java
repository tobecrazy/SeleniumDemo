package com.dbyl.tests.training.day2;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	@FindBy(css = "a[title='Recover your forgotten password']")
	WebElement forgetPasswordLink;
	@FindBy(how = How.ID, using = "email")
	WebElement emailAddress;
	@FindBy(how = How.ID, using = "passwd")
	WebElement password;
	WebElement loginButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void typeEmail(String email) {
		emailAddress.sendKeys(email);
	}

	public void typePassword(String passwd) {
		password.sendKeys(passwd);
	}
	
	public void clickOnLogin()
	{
		loginButton.submit();
	}
}
