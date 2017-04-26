package main.java.com.dbyl.designpattern.day1.prodcut;

public class ChromeDriver implements IWebDriver {

	@Override
	public void runDriver() throws Exception {
		System.out.println(this.getClass().getSimpleName() + " is running");

	}

}
