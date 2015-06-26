package com.dbyl.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.basics.Debug;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dbyl.libarary.utils.DriverFactory;
import com.dbyl.libarary.utils.RemoteBrowserBean;

public class MapTest {

	private  WebDriver driver;
	
	@BeforeClass(alwaysRun=true)
	public void beforeTest()
	{
		driver = DriverFactory.getRemoteDriver(new RemoteBrowserBean("chrome"));
	}
	@Test(groups = "MapTest")
	public void mapTest() throws FindFailed {
		Debug.setDebugLevel(3);
		Screen s = new Screen();
		String URL = "http://www.amap.com/";
		
		Actions actions = new Actions(driver);
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		WebElement chooseCityElement = driver.findElement(By
				.xpath("//div/span[@class='icon_expand cursor ml5']"));
		chooseCityElement.click();
		WebElement city_iframe = driver.findElement(By
				.xpath("//iframe[@id='city_iframe']"));
		driver.switchTo().frame(city_iframe);

		// 选择北京
		WebElement BJ = driver.findElement(By.xpath("//div/a[text()='北京']"));
		BJ.click();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.switchTo().defaultContent();
		// 选择工具
		WebElement tools = driver.findElement(By
				.xpath("//div/span[text()='工具']"));
		actions.moveToElement(tools).click().perform();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Pattern cj = new Pattern("D:\\MyBlog\\CJ.png");
		if (s.find(cj) != null) {
			s.click(cj);
		}
		Pattern bjbz = new Pattern("D:\\MyBlog\\BJBZ.png");
		s.click(bjbz);

		Pattern bjnz = new Pattern("D:\\MyBlog\\BJNZ.png");
		s.click(bjnz);

		s.rightClick();
 

		WebElement inputBoxElement = driver.findElement(By
				.xpath("//input[@id='keywordTxt']"));
		WebElement searchButton = driver.findElement(By
				.xpath("//input[starts-with(@class,'magnifier_button')]"));
		inputBoxElement.clear();
		inputBoxElement.sendKeys("天安门");
		searchButton.submit();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		WebElement tiAnMenElement = driver.findElement(By
				.xpath("//div[@title='天安门']"));
		tiAnMenElement.click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		WebElement comeToHereElement = driver.findElement(By
				.xpath("//div[@class='route']//li[text()='到这里去']"));
		comeToHereElement.click();

		WebElement setStartLocationElement = driver.findElement(By
				.xpath("//div/input[@class='route-input srh-ipt']"));
		setStartLocationElement.sendKeys("火车站");
		WebElement routeByBus = driver.findElement(By
				.xpath("//div[@id='rout-by-bus']"));
		routeByBus.click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		WebElement startFrom = driver
				.findElement(By
						.xpath("//div[@class='start_end_item_title' and contains(text(),'北京站')]"));

		actions.moveToElement(startFrom)
				.click(driver.findElement(By
						.xpath("//a[contains(text(),'设为起点') and @data-name='北京站']")))
				.perform();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//div[@class='amap-zoom-plus']")).click();

	}
	@AfterClass(alwaysRun=true)
	public void afterTest()
	{
		driver.quit();
	}
	

}
