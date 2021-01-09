package com.dbyl.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class JPressTest {
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","webDriver/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/jpress/admin/login");
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("selenium");
		driver.findElement(By.xpath("//button[text()='登陆']")).submit();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 
	}

}
