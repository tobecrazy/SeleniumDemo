package main.java.com.dbyl.libarary.listeners;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import main.java.com.dbyl.libarary.utils.DriverFactory;
import main.java.com.dbyl.libarary.utils.Log;
import main.java.com.dbyl.libarary.utils.UITest;

/**
 * 
 * @author Young
 *
 */
public class TestNGListener extends TestListenerAdapter {
	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Log log = new Log(this.getClass());

	@Override
	public void onTestSuccess(ITestResult tr) {
		log.info("Test Success");
		super.onTestSuccess(tr);
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		log.error("Test Failure");
		Throwable throwable = tr.getThrowable();
		if (throwable != null) {
			log.error(throwable.getMessage());
		}
		log.error(tr.getTestName() + " \n" + tr.getStatus());

		super.onTestFailure(tr);
		takeScreenShot(tr);
	}

	private void takeScreenShot(ITestResult tr) {

		UITest b = (UITest) tr.getInstance();
		WebDriver currentDirver = DriverFactory.getInstance().getDriver();
		log.info(currentDirver.getTitle() + "\n");

		b.takeScreenShot();

	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		log.error("Test Skipped");
		super.onTestSkipped(tr);
	}

	@Override
	public void onTestStart(ITestResult result) {
		log.info("---------------On Test Start-------------");
		super.onTestStart(result);
	}

	@Override
	public void onStart(ITestContext testContext) {

		ITestNGMethod[] methods = testContext.getAllTestMethods();
		for (ITestNGMethod method : methods) {
			String[] groups = method.getGroups();
			for (String group : groups) {
				log.info("----------------Test Group-------------");
				log.debug(group);
				log.info("---------------------------------------");
			}
		}

		super.onStart(testContext);
		Date date1 = testContext.getStartDate();

		log.info("----------------Test Start-------------");
		log.info("---------------------------------------");
		log.info("----------------" + sf.format(date1) + "-------------");
		log.info("---------------------------------------");

	}

	@Override
	public void onFinish(ITestContext testContext) {

		super.onFinish(testContext);

		// List of test results which we will delete later
		ArrayList<ITestResult> testsToBeRemoved = new ArrayList<ITestResult>();
		// collect all id's from passed test
		Set<Integer> passedTestIds = new HashSet<Integer>();
		for (ITestResult passedTest : testContext.getPassedTests().getAllResults()) {
			log.info("PassedTests = " + passedTest.getName());
			passedTestIds.add(getId(passedTest));
		}

		Set<Integer> failedTestIds = new HashSet<Integer>();
		for (ITestResult failedTest : testContext.getFailedTests().getAllResults()) {
			log.info("failedTest = " + failedTest.getName());
			// id = class + method + dataprovider
			int failedTestId = getId(failedTest);

			// if we saw this test as a failed test before we mark as to be
			// deleted
			// or delete this failed test if there is at least one passed
			// version
			if (failedTestIds.contains(failedTestId) || passedTestIds.contains(failedTestId)) {
				testsToBeRemoved.add(failedTest);
			} else {
				failedTestIds.add(failedTestId);
			}
		}

		// finally delete all tests that are marked
		for (Iterator<ITestResult> iterator =

				testContext.getFailedTests().getAllResults().iterator(); iterator.hasNext();) {
			ITestResult testResult = iterator.next();
			if (testsToBeRemoved.contains(testResult)) {
				log.info("Remove repeat Fail Test: " + testResult.getName());
				iterator.remove();
			}
		}

		log.info("Test Finish");
		Date date2 = testContext.getStartDate();

		log.info("----------------Test Finish-------------");
		log.info("---------------------------------------");
		log.info("----------------" + sf.format(date2) + "-------------");
		log.info("---------------------------------------");
	}

	private int getId(ITestResult result) {
		int id = result.getTestClass().getName().hashCode();
		id = id + result.getMethod().getMethodName().hashCode();
		id = id + (result.getParameters() != null ? Arrays.hashCode(result.getParameters()) : 0);
		return id;
	}
}
