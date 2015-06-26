package com.dbyl.libarary.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/***
 * 
 * @author Young
 *
 */
public class DriverFactory {

	private static String chromedriver;
	private static String fireBug;
	private static Properties p = null;
	private static String IEDriverServer;
	private static String config = "C:\\Users\\Young\\workspace\\Demo\\config.properties";

	public static WebDriver getHtmlUnit() {
		HtmlUnitDriver ht = new HtmlUnitDriver();
		return ht;
	}

	public static WebDriver getChromeDriver() {

		try {
			p = getProperties();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (p != null) {
			chromedriver = p.getProperty("chromedriver");
		}
		System.out.print(chromedriver);
		System.setProperty("webdriver.chrome.driver", chromedriver);
		// ChromeDriverService.Builder builder=new
		// ChromeDriverService.Builder();
		// File file=new File(chromedriver);
		// int port=12643;
		// ChromeDriverService
		// service=builder.usingDriverExecutable(file).usingPort(port).build();
		// try {
		// service.start();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		ChromeOptions options = new ChromeOptions();
		// options.addExtensions(new File(""));
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("chrome.switches",
				Arrays.asList("--start-maximized"));
		options.addArguments("--test-type", "--start-maximized");
		WebDriver driver = new ChromeDriver(options);
		return driver;
	}

	public static Properties getProperties() throws IOException {
		Properties properties = new Properties();
		FileInputStream inStream = new FileInputStream(new File(config));
		properties.load(inStream);
		return properties;
	}

	public static WebDriver getFirefoxDriver() {
		try {
			WindowsUtils.tryToKillByName("firefox.exe");
		} catch (Exception e) {
			System.out.println("can not find firefox process");
		}
		if (p != null) {
			fireBug = p.getProperty("fireBug");
		}
		File file = new File(fireBug);
		FirefoxProfile profile = new FirefoxProfile();
		// profile.setPreference("network.proxy.type", 2);
		// profile.setPreference("network.proxy.autoconfig_url",
		// "http://proxy.successfactors.com:8083");
		// profile.setPreference("network.proxy.no_proxies_on", "localhost");
		//

		// profile.setPreference("network.proxy.http",
		// "proxy.domain.example.com");
		// profile.setPreference("network.proxy.http_port", 8080);
		// profile.setPreference("network.proxy.ssl",
		// "proxy.domain.example.com");
		// profile.setPreference("network.proxy.ssl_port", 8080);
		// profile.setPreference("network.proxy.ftp",
		// "proxy.domain.example.com");
		// profile.setPreference("network.proxy.ftp_port", 8080);
		// profile.setPreference("network.proxy.socks",
		// "proxy.domain.example.com");
		// profile.setPreference("network.proxy.socks_port", 8080);

		try {
			profile.addExtension(file);
			profile.setPreference("extensions.firebug.currentVersion", "2.0.4");
			profile.setPreference("extensions.firebug.allPagesActivation",
					"off");
		} catch (IOException e3) {
			e3.printStackTrace();
		}

		WebDriver driver = new FirefoxDriver(profile);
		return driver;

	}

	public static WebDriver getIEDriver() {
		if (p != null) {
			IEDriverServer = p.getProperty("IEDriverServer");
		}
		System.setProperty("webdriver.ie.driver", IEDriverServer);
		WebDriver driver = new InternetExplorerDriver();
		return driver;
	}

	/**
	 * This method will create RemoteWebdriver
	 * @author Young
	 * @param remoteBrowserBean
	 * @return WebDriver
	 */
	public static WebDriver getRemoteDriver(RemoteBrowserBean remoteBrowserBean) {
		DesiredCapabilities capability = null;
		if (remoteBrowserBean.getBrowserName().contains("firefox")) {
			capability = DesiredCapabilities.firefox();
		} else if (remoteBrowserBean.getBrowserName().contains("chrome")) {
			capability = DesiredCapabilities.chrome();
		}

		WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(
					new URL(remoteBrowserBean.getHubURL()), capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		capability.setBrowserName(remoteBrowserBean.getBrowserName());
		capability.setVersion(remoteBrowserBean.getVersion());
		capability.setCapability(remoteBrowserBean.getPlatform()[0],
				remoteBrowserBean.getPlatform()[1]);
		driver.manage().window().maximize();
		return driver;
	}
}
