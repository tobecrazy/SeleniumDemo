package main.java.com.dbyl.designpattern.day1;

import main.java.com.dbyl.designpattern.day1.factory.DriverFactory;
import main.java.com.dbyl.designpattern.day1.factory.WebElementFactory;
import main.java.com.dbyl.designpattern.day1.prodcut.ButtonWebElement;
import main.java.com.dbyl.designpattern.day1.prodcut.ChromeDriver;
import main.java.com.dbyl.designpattern.day1.prodcut.FirefoxDriver;
import main.java.com.dbyl.designpattern.day1.prodcut.IWebDriver;
import main.java.com.dbyl.designpattern.day1.prodcut.IWebElement;

public class TestFactoryPattern {

	public static void main(String[] args) throws Exception {
		IWebDriver driver = new DriverFactory().generateDriver(FirefoxDriver.class.getName());
		driver.runDriver();
		driver = new DriverFactory().generateDriver(ChromeDriver.class.getName());
		driver.runDriver();
		IWebElement element = new WebElementFactory().generateWebElement(ButtonWebElement.class.getName());
		element.present();
	}

}
