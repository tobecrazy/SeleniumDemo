package com.dbyl.tests;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.dbyl.libarary.utils.DriverFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class JDaddress.
 */
public class JDaddress {
	
	/** The driver. */
	private WebDriver driver;

	/**
	 * Test JD.
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	@Test(groups = { "JDaddress" })
	public void testJD() throws InterruptedException {
		WindowsUtils.getProgramFilesPath();
		driver =DriverFactory.getInstance().getChromeDriver();  // DriverFactory.getRemoteDriver(new RemoteBrowserBean("chrome"));
		driver.get("https://item.jd.com/4357281.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		// 打开
		isElementPresent(driver, "//div[@id='store-selector' or @id='stock-address']//div");

		Actions actions = new Actions(driver);
		actions.clickAndHold(driver.findElement(By.xpath("//div[@id='store-selector' or contains(@class,'address-select')]//div"))).perform();
		// 选择
		driver.findElement(By.xpath("//div[@id=\"JD-stock\"]/div[@class=\"mt\"]//li[1]/a")).click();
		driver.findElement(By.linkText("上海")).click();
		driver.findElement(By.xpath("//div[@id=\"JD-stock\"]/div[@class=\"mt\"]//li[2]/a")).click();
		driver.findElement(By.linkText("浦东新区")).click();
		driver.findElement(By.xpath("//div[@id=\"JD-stock\"]/div[@class=\"mt\"]//li[3]/a")).click();
		driver.findElement(By.linkText("张江镇")).click();
		Thread.sleep(3000);
		WebElement addBar = driver.findElement(By.xpath("//div[@id='store-selector']//div[@title]"));
		System.out.println(addBar.getText());
		Assert.assertTrue(addBar.getText().equals("上海浦东新区张江镇"), "can't fond key words");

	}

	/**
	 * Checks if is element present.
	 *
	 * @param driver the driver
	 * @param xpath the xpath
	 * @return true, if is element present
	 */
	public static boolean isElementPresent(WebDriver driver, final String xpath) {

		boolean isPresent = false;
		WebDriverWait wait = new WebDriverWait(driver, 60);
		isPresent = wait.until( new Function<WebDriver, WebElement>(){
			@Override
			public WebElement apply(WebDriver d) {
				return d.findElement(By.xpath(xpath));
			}
		}).isDisplayed();
		return isPresent;
	}

	/**
	 * Tear down.
	 */
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
