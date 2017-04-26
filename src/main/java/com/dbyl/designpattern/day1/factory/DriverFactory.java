package main.java.com.dbyl.designpattern.day1.factory;

import main.java.com.dbyl.designpattern.day1.prodcut.ChromeDriver;
import main.java.com.dbyl.designpattern.day1.prodcut.FirefoxDriver;
import main.java.com.dbyl.designpattern.day1.prodcut.IWebDriver;

/**
 * 
 * @author young
 *
 */
public class DriverFactory implements IDriverFactory {

	@Override
	public IWebDriver generateDriver(String key) throws Exception {
		System.out.println("Generate " + key);
		// if (ChromeDriver.class.getSimpleName().equals(key)) {
		// return new ChromeDriver();
		// } else if (FirefoxDriver.class.getSimpleName().equals(key)) {
		// return new FirefoxDriver();
		// } else {
		// return null;
		// }
		return (IWebDriver) getProduct(key);

	}

	/**
	 * @author young
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public Object getProduct(String key) throws Exception {
		Class clazz = Class.forName(key);
		return clazz.newInstance();

	}

}
