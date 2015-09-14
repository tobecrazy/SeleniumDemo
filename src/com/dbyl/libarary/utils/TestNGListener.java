package com.dbyl.libarary.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

/**
 * 
 * @author Young
 *
 */
public class TestNGListener extends TestListenerAdapter {
	Log log = new Log(this.getClass());

	@Override
	public void onTestSuccess(ITestResult tr) {
		log.info("Test Success");
		super.onTestSuccess(tr);
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		log.error("Test Failure");
		super.onTestFailure(tr);
		takeScreenShot(tr);
	}

	private void takeScreenShot(ITestResult tr) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		String dateStr = sf.format(date);
		String path = tr.getTestName() + "_" + dateStr + ".png";
		WebDriver currentDirver = DriverFactory.getCurrentDriver();
		takeScreenShot((TakesScreenshot) currentDirver, path);
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		log.error("Test Skipped");
		super.onTestSkipped(tr);
	}

	@Override
	public void onTestStart(ITestResult result) {
		log.info("Test Finsh");
		super.onTestStart(result);
	}

	@Override
	public void onStart(ITestContext testContext) {
		log.info("Test Start");
		super.onStart(testContext);
	}

	@Override
	public void onFinish(ITestContext testContext) {
		log.info("Test Finish");
		super.onFinish(testContext);
	}

	/**
	 * @author Young
	 * @param drivername
	 * @param path
	 */
	public void takeScreenShot(TakesScreenshot drivername, String path) {
		// this method will take screen shot ,require two parameters ,one is
		// driver name, another is file name
		String currentPath = System.getProperty("user.dir"); // get current work
		log.info(currentPath);
		File scrFile = drivername.getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy
		try {
			log.info("save snapshot path is:" + currentPath + path);
			FileUtils.copyFile(scrFile, new File(currentPath + "\\" + path));
		} catch (Exception e) {
			log.error("Can't save screenshot");
			e.printStackTrace();
		} finally {
			log.info("screen shot finished");
		}
	}
}
