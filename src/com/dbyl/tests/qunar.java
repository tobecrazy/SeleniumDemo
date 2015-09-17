package com.dbyl.tests;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dbyl.libarary.utils.DriverFactory;
import com.dbyl.libarary.utils.RemoteBrowserBean;
import com.google.common.base.Predicate;

public class qunar {

	public static void main(String[] args) throws InterruptedException {

		RemoteBrowserBean remoteBrowserBean = new RemoteBrowserBean("chrome");
		WebDriver driver = DriverFactory.getRemoteDriver(remoteBrowserBean);

		driver.get("http://flight.qunar.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		WebElement from_inpox = driver
				.findElement(By
						.xpath("//div[@id='js_flighttype_tab_domestic']//input[@name='fromCity']"));
		WebElement to_inpox = driver
				.findElement(By
						.xpath("//div[@id='js_flighttype_tab_domestic']//input[@name='toCity']"));
		WebElement from_date = driver
				.findElement(By
						.xpath("//div[@id='js_flighttype_tab_domestic']//input[@name='fromDate']"));
		WebElement sigleWayCheckBox = driver
				.findElement(By
						.xpath("//div[@id='js_flighttype_tab_domestic']//input[@class='inp_chk js-searchtype-oneway']"));
		if (!sigleWayCheckBox.isSelected()) {
			sigleWayCheckBox.click();
		}

		System.out.print(from_inpox.getSize().getHeight() + "\n"
				+ from_inpox.getLocation().getX() + "\n"
				+ from_inpox.getLocation().getY() + "\n"
				+ from_inpox.getSize().getWidth());

		from_inpox.clear();
		// from_inpox.sendKeys("BJ");
		// Thread.sleep(8000);
		// By bj = new By.ByXPath(
		// "//div[@class='qcbox-fixed js-suggestcontainer']//td[contains(text(),'北京')]");
		// if (isElementPresent(driver, bj, 20)) {
		// driver.findElement(bj).click();
		// }

		//inputbox is a WebElement
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value=\"北京\"", from_inpox);

		to_inpox.clear();
		to_inpox.sendKeys("SH");
		Thread.sleep(8000);
		By sh = new By.ByXPath(
				"//div[@class='qcbox-fixed js-suggestcontainer']//td[contains(text(),'上海')]");
		if (isElementPresent(driver, sh, 20)) {
			driver.findElement(sh).click();
		}

		Actions actions = new Actions(driver);
		actions.moveToElement(from_inpox).click().perform();
		driver.findElement(
				By.xpath("//div[@data-panel='domesticfrom-flight-hotcity-from']//a[@class='js-hotcitylist' and text()='西安']"))
				.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		actions.moveToElement(to_inpox).click().perform();
		driver.findElement(
				By.xpath("//div[@data-panel='domesticto-flight-hotcity-to']//a[@class='js-hotcitylist' and text()='北京']"))
				.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		from_date.clear();
		from_date.sendKeys(getDateAfterToday(7));
		WebElement search = driver
				.findElement(By
						.xpath("//div[@id='js_flighttype_tab_domestic']//button[@class='btn_search']"));
		search.submit();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		WebElement page2 = driver.findElement(By
				.xpath("//div[@id='hdivPager']/a[@value='2']"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView()", page2);
		page2.click();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.findElement(
				By.xpath("(//div[@class='avt_trans']//p[contains(text(),'每段航班均需缴纳税费')]/ancestor::div//div[@class='a_booking']/a)[3]"))
				.click();
		driver.findElement(
				By.xpath("//div[@id='flightbarXI883']//div[@class='t_bk']/a"))
				.click();
	}

	public static String getDateAfterToday(int dateAfterToday) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, +dateAfterToday);
		System.out.println(cal.getTime().toString());
		Date date = cal.getTime();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(df.format(date));
		return df.format(date);
	}

	/**
	 * @author Young
	 * @param driver
	 * @param by
	 * @param timeOut
	 * @return
	 */
	public static boolean isElementPresent(WebDriver driver, final By by,
			int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		boolean isPresent = false;
		try {
			isPresent = wait.until(new ExpectedCondition<WebElement>() {
				@Override
				public WebElement apply(WebDriver d) {
					return d.findElement(by);
				}
			}).isDisplayed();
		} catch (Exception e) {
			isPresent = false;
		}
		return isPresent;
	}
}
