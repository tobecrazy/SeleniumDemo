package com.dbyl.libarary.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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
		UITest b = (UITest) tr.getInstance();
		WebDriver currentDirver = b.getDriver();
		System.out.println(currentDirver.getTitle());
		b.takeScreenShot();

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

		// List of test results which we will delete later
		ArrayList<ITestResult> testsToBeRemoved = new ArrayList<ITestResult>();
		// collect all id's from passed test
		Set<Integer> passedTestIds = new HashSet<Integer>();
		for (ITestResult passedTest : testContext.getPassedTests()
				.getAllResults()) {
			log.info("PassedTests = " + passedTest.getName());
			passedTestIds.add(getId(passedTest));
		}

		Set<Integer> failedTestIds = new HashSet<Integer>();
		for (ITestResult failedTest : testContext.getFailedTests()
				.getAllResults()) {
			log.info("failedTest = " + failedTest.getName());
			// id = class + method + dataprovider
			int failedTestId = getId(failedTest);

			// if we saw this test as a failed test before we mark as to be
			// deleted
			// or delete this failed test if there is at least one passed
			// version
			if (failedTestIds.contains(failedTestId)
					|| passedTestIds.contains(failedTestId)) {
				testsToBeRemoved.add(failedTest);
			} else {
				failedTestIds.add(failedTestId);
			}
		}

		// finally delete all tests that are marked
		for (Iterator<ITestResult> iterator =

		testContext.getFailedTests().getAllResults().iterator(); iterator
				.hasNext();) {
			ITestResult testResult = iterator.next();
			if (testsToBeRemoved.contains(testResult)) {
				log.info("Remove repeat Fail Test: " + testResult.getName());
				iterator.remove();
			}
		}

	}

	private int getId(ITestResult result) {
		int id = result.getTestClass().getName().hashCode();
		id = id + result.getMethod().getMethodName().hashCode();
		id = id
				+ (result.getParameters() != null ? Arrays.hashCode(result
						.getParameters()) : 0);
		return id;
	}

}
