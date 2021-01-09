package com.dbyl.tests.training.day5;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class NuomiPage {
	public WebDriver driver;
	@FindBy(id = "j-barLoginBtn")
	private WebElement login ;
	

	public NuomiPage(WebDriver driver) {
		this.driver = driver;
		// initial Page web element
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Login 
	 */
	public void verifyLoginPresent()
	{
		this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		Assert.assertEquals("登录", login.getText());
	}
}
