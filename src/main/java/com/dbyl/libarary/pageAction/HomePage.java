package com.dbyl.libarary.pageAction;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.dbyl.libarary.utils.BasePage;
import com.dbyl.libarary.utils.Locator;


public class HomePage extends BasePage {
	private Locator profile=new Locator("//div[@class='top-nav-profile']");
	private Locator myMainPage= new Locator("myMainPage");
	public HomePage(WebDriver driver) throws Exception {
		super(driver);
	}

	public void clickOnMyProfile() throws Exception
	{
		click(profile);
	}
	
	public void clickAndHoldProfile() throws IOException
	{
		clickAndHold(profile);
	}
	
	public void clickOnMainPage() throws Exception
	{
		clickAndHoldProfile();
		click(myMainPage);
	}
}
