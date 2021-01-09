package com.dbyl.tests.training.day5;


import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaiduPage {
	public WebDriver driver;
	@FindBy(css ="a[name='tj_trnuomi']" )
	@CacheLookup
	private WebElement nuomi;

	@FindBy(how = How.XPATH, using = "//input[@id='kw']")
	@CacheLookup
	private WebElement searchInputBox;

	@FindBy(xpath = "//input[@id='su']")
	@CacheLookup
	private WebElement searchButton;

	@FindBys({ @FindBy(className = "A"), @FindBy(className = "B") })
	private WebElement links;

	/**
	 * @author young
	 * @param driver
	 */
	public BaiduPage(WebDriver driver) {
		this.driver = driver;
		//initial Page web element
//		PageFactory.initElements(driver, this);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
	}
 

	/**
	 * Click On Search Button
	 * 
	 * @author young
	 * 
	 * @return
	 */
	public BaiduPage clickOnSearchButton() {
		searchButton.click();
		return this;
	}

	/**
	 * Search InputBox
	 * 
	 * @author young
	 * @param keyword
	 */
	public void typeSearchInputBox(String keyword) {
		searchInputBox.clear();
		searchInputBox.sendKeys(keyword);
	}

	/**
	 * Search keyword
	 * 
	 * @author young
	 * @param keyword
	 * @throws InterruptedException
	 */
	public void searchKeyWord(String keyword) throws InterruptedException {
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
	 */
	public NuomiPage navigateToNuomiPage()
	{
		nuomi.click();
		NuomiPage nuomi=new NuomiPage(this.driver);
		return nuomi;
	}
}
