package com.dbyl.tests.training.day5;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PageObjectTest {
	public WebDriver driver;

	@BeforeClass
	public void initDriver() {
		System.setProperty("webdriver.gecko.driver", "webDriver/geckodriver");
		driver = new FirefoxDriver();
		// DesiredCapabilities capability =
		// DesiredCapabilities.internetExplorer();
		// capability.setBrowserName("chrome");
		// // // capability.setPlatform(Platform.WINDOWS);
		// capability.setVersion("55");
		//
		// try {
		// driver = new RemoteWebDriver(new
		// URL("http://192.168.2.148:4444/wd/hub"), capability);
		// } catch (MalformedURLException e) {
		// e.printStackTrace();
		// }
		// System.setProperty("webdriver.chrome.driver",
		// "webDriver/chromedriver");
		// driver = new ChromeDriver();
	}

	@Test(priority = 1)
	public void Search() throws InterruptedException {
		driver.get("http://www.baidu.com");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		BaiduPage baidu = new BaiduPage(driver);
		baidu.searchKeyWord("Selenium");

	}

	// @Test(priority=2)
	public void loginTest() {
		driver.get("http://www.baidu.com");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		BaiduPage baidu = new BaiduPage(driver);
		NuomiPage nuomi = baidu.navigateToNuomiPage();
		nuomi.verifyLoginPresent();

	}

	// @Test(priority = 3)
	public void loginTest2() throws Exception {
		driver.get("http://www.baidu.com");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		BaiduPage2 baidu = new BaiduPage2(driver);
		NuomiPage2 nuomi = baidu.navigateToNuomiPage();
		nuomi.verifyLoginPresent();

	}

	// public BaiduPage login(String userName,String password)
	// {
	// this.typeUerName(userName);
	// this.typePassword(password);
	// this.clickOnLoginButton();
	// return null;
	// }

	@AfterClass
	public void stopDriver() {
		driver.quit();
	}

}
