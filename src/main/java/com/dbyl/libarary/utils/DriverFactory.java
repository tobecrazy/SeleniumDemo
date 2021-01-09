package com.dbyl.libarary.utils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Properties;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.dbyl.libarary.utils.Context.BrowserType;

/**
 * *.
 *
 * @author Young
 * @version V1.2
 */
public class DriverFactory {

	/** The chromedriver. */
	private String chromedriver;

	/** The fire bug. */
	private String fireBug;

	/** The firefoxdriver. */
	private String firefoxdriver;

	/** The p. */
	private Properties p = null;

	/** The IE driver server. */
	private String IEDriverServer;

	/** The EDGE driver. */
	private String EDGEDriver;

	/** The config. */
	private String config = System.getProperty("user.dir") + "/config.properties";

	/** The log. */
	static LogUtils log = new LogUtils(DriverFactory.class);

	/** The OS type. */
	private String OSType = System.getProperty("os.name");

	/** The current dir. */
	private String currentDir = System.getProperty("user.dir");

	/** The driver. */
	public WebDriver driver = null;

	/** The driverfactory. */
	public static DriverFactory driverfactory;

	// public static WebDriver getHtmlUnit() {
	// HtmlUnitDriver driver = new HtmlUnitDriver();
	// log.info("Create HtmlUnitDrive ");
	// return driver;
	// }

	/**
	 * Gets the chrome driver.
	 *
	 * @author young
	 * @return the chrome driver
	 */
	public WebDriver getChromeDriver() {

		try {
			p = ConfigUtils.getProperties(config);
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		if (p != null) {
			if (!OSType.contains("Mac")) {
				chromedriver = p.getProperty("chromedriver");
			} else {
				chromedriver = p.getProperty("MAC_chromedriver");
			}

		}

		log.info("chrome driver path is " + chromedriver);
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
		// e.printStackTrace();
		// }
		ChromeOptions options = new ChromeOptions();
		// options.addExtensions(new File(""));
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("chrome.switches", Arrays.asList("--start-maximized"));
		options.addArguments("--test-type", "--start-maximized");
		driver = new ChromeDriver(options);
		log.info("Create ChromeDrive ");
		return driver;
	}

	/**
	 * Gets the firefox driver.
	 *
	 * @author young
	 * @return the firefox driver
	 */
	public WebDriver getFirefoxDriver() {
		try {
			p = ConfigUtils.getProperties(config);
			WindowsUtils.killByName("firefox");

		} catch (Exception e) {
			log.error("can not find firefox process");
		}

		if (p != null) {
			fireBug = p.getProperty("fireBug");
			if (!OSType.contains("Mac")) {
				firefoxdriver = p.getProperty("firefoxdriver");
			} else {
				firefoxdriver = p.getProperty("MAC_firefoxdriver");
			}

		}
		firefoxdriver = currentDir + "/" + firefoxdriver;
		log.info("firefox geckodriver path is " + firefoxdriver);
		System.setProperty("webdriver.gecko.driver", firefoxdriver);
		File file = new File(fireBug);
		FirefoxProfile profile = new FirefoxProfile();

		// profile.setPreference("network.proxy.type", 2);
		// profile.setPreference("network.proxy.autoconfig_url",
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
			profile.setPreference("extensions.firebug.currentVersion", "2.0.17");
			profile.setPreference("extensions.firebug.allPagesActivation", "off");
		} catch (Exception e3) {
			e3.printStackTrace();
		}
		// profile.setPreference("browser.download.folderList", 2);
		// profile.setPreference("browser.download.dir", "C:\\selenium");
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
				"application/octet-stream, application/vnd.ms-excel, text/csv, application/zip,application/exe");
		// Upgrade in Selenium 3.11.0
		FirefoxOptions option = new FirefoxOptions().setProfile(profile);
		driver = new FirefoxDriver(option);
		log.info("Create FirefoxDriver ");
		return driver;

	}

	/**
	 * Gets the IE driver.
	 *
	 * @author young
	 * @return the IE driver
	 */
	@SuppressWarnings("deprecation")
	public synchronized WebDriver getIEDriver() {
		try {
			p = ConfigUtils.getProperties(config);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (p != null) {
			IEDriverServer = p.getProperty("IEDriverServer");
		}
		System.setProperty("webdriver.ie.driver", IEDriverServer);
		String PROXY = "http://proxy:8083";
		org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
		proxy.setHttpProxy(PROXY).setFtpProxy(PROXY).setSslProxy(PROXY);
		DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
		caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		caps.setCapability("ignoreProtectedModeSettings", true);
		caps.setCapability(CapabilityType.PROXY, proxy);
		InternetExplorerOptions option = new InternetExplorerOptions(caps);
		driver = new InternetExplorerDriver(option);
		return driver;
	}

	/**
	 * This method will create RemoteWebdriver.
	 *
	 * @author Young
	 * @param remoteBrowserBean
	 *            the remote browser bean
	 * @return WebDriver
	 */
	public WebDriver getRemoteDriver(RemoteBrowserBean remoteBrowserBean) {
		DesiredCapabilities capability = null;
		if (remoteBrowserBean.getBrowserName().contains("firefox")) {
			capability = DesiredCapabilities.firefox();
		} else if (remoteBrowserBean.getBrowserName().contains("chrome")) {
			capability = DesiredCapabilities.chrome();
		} else {
			capability = DesiredCapabilities.internetExplorer();
		}

		capability.setBrowserName(remoteBrowserBean.getBrowserName());
		capability.setVersion(remoteBrowserBean.getVersion());
		capability.setJavascriptEnabled(true);
		capability.setAcceptInsecureCerts(true);
		capability.setCapability(remoteBrowserBean.getPlatform()[0], remoteBrowserBean.getPlatform()[1]);

		try {
			driver = new RemoteWebDriver(new URL(remoteBrowserBean.getHubURL()), capability);
			driver.manage().window().maximize();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
	}

	/**
	 * Gets the EDGE driver.
	 *
	 * @author young
	 * @return the EDGE driver
	 */
	public WebDriver getEDGEDriver() {
		try {
			p = ConfigUtils.getProperties(config);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (p != null) {
			EDGEDriver = p.getProperty("EDGEDriver");
		}
		System.setProperty("webdriver.edge.driver", EDGEDriver);
		String PROXY = "https://raw.githubusercontent.com/seveniruby/gfwlist2pac/master/test/proxy.pac";
		Proxy proxy = new org.openqa.selenium.Proxy();
		proxy.setHttpProxy(PROXY).setFtpProxy(PROXY).setSslProxy(PROXY);
		EdgeOptions options = new EdgeOptions().setProxy(proxy);
		options.setPageLoadStrategy("normal");

		driver = new EdgeDriver(options);
		return driver;
	}

	/**
	 * Gets the single instance of DriverFactory.
	 *
	 * @author young
	 * @return single instance of DriverFactory
	 */
	public static DriverFactory getInstance() {
		if (driverfactory == null) {
			synchronized (DriverFactory.class) {
				driverfactory = new DriverFactory();
			}
		}
		return driverfactory;
	}

	/**
	 * Instantiates a new driver factory.
	 */
	public DriverFactory() {

	}

	/**
	 * Close.
	 *
	 * @author young Call GC
	 */
	public static void close() {
		if (driverfactory != null) {
			driverfactory = null;
		}
	}

	/**
	 * Gets the driver.
	 *
	 * @return the driver
	 */
	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * This method will get BrowserType.
	 *
	 * @author young
	 * @return the browser type
	 */
	public BrowserType getBrowserType() {

		if (driver instanceof FirefoxDriver) {
			return BrowserType.firefox;
		} else if (driver instanceof ChromeDriver) {
			return BrowserType.chrome;
		} else if (driver instanceof InternetExplorerDriver) {
			return BrowserType.ie;
		} else if (driver instanceof EdgeDriver) {
			return BrowserType.edge;
		} else if (driver instanceof SafariDriver) {
			return BrowserType.safari;
		} else {
			return null;
		}

	}
}
