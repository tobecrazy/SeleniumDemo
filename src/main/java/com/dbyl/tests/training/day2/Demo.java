package com.dbyl.tests.training.day2;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Demo {
	String row = "3";
	String column = "1";

	@Test
	public void clickUpload() {
		System.setProperty("webdriver.gecko.driver", "webDriver/geckodriver");
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://localhost:8081/");
		WebElement upload = driver.findElement(By.cssSelector("input[type='file']"));
		upload.sendKeys("webDriver/geckodriver");

		System.out.println(getCell(driver, row, column));
	}

	private String getCell(WebDriver driver, String row, String column) {
		String xpath = "//table//tr[" + row + "]/td[" + column + "]";
		WebElement cell = driver.findElement(By.xpath(xpath));
		return cell.getText();

	}

}
