package com.dbyl.tests;

import java.awt.AWTException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dbyl.libarary.utils.DriverFactory;

public class getAllData {
	WebDriver driver;

	@BeforeClass
	public void beforeTest() {
		driver = DriverFactory.getInstance().getChromeDriver();
	}

	@Test(groups = "Test")
	public void main() throws AWTException, IOException {

		driver.get("http://www.lhfdc.gov.cn/templets/lh/aspx/HPMS/ProjectList.aspx");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		int i = 1;
		while (true) {

			ArrayList<String> linkNames = new ArrayList<String>();
			List<WebElement> elements = driver.findElements(By
					.xpath("//a[contains(@href,'ProjectInfo.aspx?code=')]/u"));
			// get all link name
			for (WebElement e : elements) {
				linkNames.add(e.getText());
			}

			for (String link : linkNames) {

				String tempXpath = "//u[contains(text(),'" + link
						+ "')]/parent::a";
				// WebElement e = driver.findElement(By.xpath(tempXpath));
				WebElement id = driver
						.findElement(By
								.xpath("//a/u[contains(text(),'"
										+ link
										+ "')]/parent::a/parent::td/preceding-sibling::td"));
				String sale = "(//a/u[contains(text(),'" + link
						+ "')]/parent::a/parent::td/following-sibling::td)[3]";
				WebElement saleCode = driver.findElement(By.xpath(sale));

				String dev = "(//a/u[contains(text(),'" + link
						+ "')]/parent::a/parent::td/following-sibling::td)[1]";
				WebElement devN = driver.findElement(By.xpath(dev));
				writeToTXT(i + "," + link + "," + devN.getText() + ","
						+ saleCode.getText() + "\n");
				i++;
				// e.click();
				// driver.manage().timeouts().implicitlyWait(60,
				// TimeUnit.SECONDS);
				// driver.manage().timeouts().pageLoadTimeout(60,
				// TimeUnit.SECONDS);
				// WebElement
				// buildings=driver.findElement(By.xpath("//div[@id='infotable_lpb_but']"));
				// buildings.click();
				// driver.navigate().back();
				// driver.manage().timeouts().implicitlyWait(60,
				// TimeUnit.SECONDS);
				// driver.manage().timeouts().pageLoadTimeout(60,
				// TimeUnit.SECONDS);
				// System.out.println(driver.getTitle());
			}
			WebElement nextPage = driver
					.findElement(By
							.xpath("//a[@id='PageNavigator1_LnkBtnNext' and not(@disabled)]"));
			nextPage.click();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		}

	}

	public void writeToTXT(String message) throws IOException {
		BufferedWriter bf = null;
		try {
			// set true ,avoid
			bf = new BufferedWriter(new FileWriter("report.csv", true));
			bf.write(message);
			bf.flush();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			bf.close();
		}


	}

	@AfterClass
	public void afterTest() {
		driver.quit();
	}
}
