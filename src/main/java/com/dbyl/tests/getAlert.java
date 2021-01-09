package com.dbyl.tests;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.dbyl.libarary.utils.DriverFactory;

public class getAlert {
	private WebDriver driver;

	@Test(groups = { "ChromeDriver" })
	public void FireFoxDriver() throws InterruptedException {
		WindowsUtils.getProgramFilesPath();
		driver = DriverFactory.getInstance().getFirefoxDriver();
		String path = System.getProperty("user.dir");
		System.out.print("file://" + path + "/data/index.html");
		driver.get("file://" + path + "/data/index.html");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebElement target1 = driver.findElement(By.xpath("//a[@id='target1']"));
		String currentWindow = driver.getWindowHandle();
		String target1Window = null;
		target1.click();
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			if (!currentWindow.equals(window)) {
				target1Window = window;
				driver.switchTo().window(window);
			}
		}
		WebElement target2 = driver.findElement(By.id("target2"));
		target2.click();

		windows = driver.getWindowHandles();
		for (String window : windows) {
			if (!currentWindow.equals(window) && !target1Window.equals(window)) {
				driver.switchTo().window(window);
			}
		}
		driver.navigate().refresh();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		alert = driver.switchTo().alert();
		String browserAlertMsg = alert.getText();  

	}

	/**
	 * @author Young
	 * @param driver
	 * @param by
	 * @return
	 */
	public static boolean isElementPresent(WebDriver driver, final By by) {

		boolean isPresent = false;
		WebDriverWait wait = new WebDriverWait(driver, 60);
		isPresent = wait.until(new Function<WebDriver, WebElement>() {
			@Override
			public WebElement apply(WebDriver d) {
				return d.findElement(by);
			}
		}).isDisplayed();
		return isPresent;
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
