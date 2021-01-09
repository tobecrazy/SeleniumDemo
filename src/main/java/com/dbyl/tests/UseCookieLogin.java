package com.dbyl.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Date;
import java.util.StringTokenizer;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dbyl.libarary.action.Cookies;
import com.dbyl.libarary.utils.DriverFactory;

public class UseCookieLogin {

	/**
	 * @author Young
	 * @param args
	 */
	private WebDriver driver;

	@BeforeClass(alwaysRun = true)
	public void beforeRun() {
		driver = DriverFactory.getInstance().getChromeDriver();
	}

	@Test(alwaysRun = true, groups = "useCookies")
	public void useCookies() {
		// TODO Auto-generated method stub
		Cookies.addCookies();
		//WindowsUtils.tryToKillByName("chrome.exe");
		WindowsUtils.getProgramFilesPath();

		driver.get("http://www.zhihu.com/");
		try {
			File file = new File("broswer.data");
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				StringTokenizer str = new StringTokenizer(line, ";");
				while (str.hasMoreTokens()) {
					String name = str.nextToken();
					String value = str.nextToken();
					String domain = str.nextToken();
					String path = str.nextToken();
					Date expiry = null;
					String dt;
					if (!(dt = str.nextToken()).equals(null)) {
						// expiry=new Date(dt);
						System.out.println();
					}
					boolean isSecure = new Boolean(str.nextToken())
							.booleanValue();
					Cookie ck = new Cookie(name, value, domain, path, expiry,
							isSecure);
					driver.manage().addCookie(ck);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		driver.get("http://www.zhihu.com/");
	}

	@AfterClass(alwaysRun = true)
	public void afterTearDown() {
		driver.quit();
	}

}
