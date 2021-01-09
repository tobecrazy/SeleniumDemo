package com.dbyl.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dbyl.libarary.utils.BasePage;
import com.dbyl.libarary.utils.DriverFactory;
import com.dbyl.libarary.utils.Locator;
import com.dbyl.libarary.utils.StringTools;

public class SelectTest {

	@Test(groups = "loginTest")
	public void runTest() throws Exception {
		WebDriver driver = DriverFactory.getInstance().getFirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.get("http://css3menu.com/");
		WebElement menu = driver.findElement(By.xpath("//span[.='How to Use']"));
		
		Actions action = new Actions(driver);
		action.clickAndHold(menu).build().perform();
		WebElement technicalQuestion = driver.findElement(By.xpath(
				"//ul[@id='css3menu_top']/li[position()=3]/div[@class='submenu']/div[@class='column']//a[contains(text(),'Technical')]"));
		technicalQuestion.click();

	}

	// public static void main(String[] args) throws IOException
	// {
	// String a=StringTools.getMatchGroup("http://www.baidu.com",
	// "\\.(\\w{1,5})\\.",1);
	// System.out.println("--->"+a);
	// Document doc = Jsoup.connect("http://www.baidu.com").get();
	// String title = doc.title();
	// System.out.println(title);
	//
	// Elements urls=doc.select("a");
	// for(Element url:urls)
	// {
	// System.out.println(url.text().trim());
	// System.out.println(url.attr("href"));
	// System.out.println(url.html());
	// }
	// }

}
