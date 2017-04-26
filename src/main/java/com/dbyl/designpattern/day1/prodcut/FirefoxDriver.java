package main.java.com.dbyl.designpattern.day1.prodcut;

/**
 * Real Product A 
 * 具体产品 A
 * 
 * @author young
 *
 */
public class FirefoxDriver implements IWebDriver {

	@Override
	public void runDriver() throws Exception {
		System.out.println(this.getClass().getSimpleName() + " is running");

	}

}
