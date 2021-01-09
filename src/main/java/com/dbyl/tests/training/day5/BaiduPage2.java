package com.dbyl.tests.training.day5;


import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class BaiduPage2 extends BasePage {
	protected BaiduPage2(WebDriver driver) throws Exception {
		super(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
	}

	public WebDriver driver;

	Locator nuomi = new Locator("nuomi");
	Locator searchInputBox = new Locator("searchInputBox");
	Locator searchButton = new Locator("searchButton");

	/**
	 * @author young
	 * @param driver
	 */

	/**
	 * Click On Search Button
	 * 
	 * @author young
	 * 
	 * @return
	 * @throws Exception
	 */
	public BaiduPage2 clickOnSearchButton() throws Exception {
		click(searchButton);
		return this;
	}

	@Override
	public WebDriver getDriver() {
		return super.getDriver();
	}

	/**
	 * Search InputBox
	 * 
	 * @author young
	 * @param keyword
	 * @throws Exception
	 */
	public void typeSearchInputBox(String keyword) throws Exception {
		type(searchInputBox, keyword);
	}

	/**
	 * Search keyword
	 * 
	 * @author young
	 * @param keyword
	 * @throws Exception
	 */
	public void searchKeyWord(String keyword) throws Exception {
		this.typeSearchInputBox(keyword);
		this.clickOnSearchButton();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		Thread.sleep(10000);
		Assert.assertTrue(getCurrentTitle().contains(keyword));
	}

	/**
	 * @author young
	 * @return
	 */
	public String getCurrentTitle() {
		return driver.getTitle();
	}

	/**
	 * Navigate To Nuomi Page
	 * 
	 * @return
	 * @throws Exception
	 */
	public NuomiPage2 navigateToNuomiPage() throws Exception {
		click(nuomi);

		NuomiPage2 nuomi = (NuomiPage2) PageReflect.getPage(NuomiPage2.class, getDriver());
		return nuomi;
	}

}
