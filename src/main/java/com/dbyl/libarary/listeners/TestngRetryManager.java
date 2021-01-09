package com.dbyl.libarary.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.dbyl.libarary.utils.LogUtils;

public class TestngRetryManager implements IRetryAnalyzer {
	LogUtils log = new LogUtils(TestngRetryManager.class);
	int defaultCount = 1;
	int maxTryCount=3;

	public TestngRetryManager() {
	}

	@Override
	public boolean retry(ITestResult result) {

		if (defaultCount <= maxTryCount) {
			String message = "running retry for  '" + result.getName()
					+ "' on class " +

					this.getClass().getName() + " Retrying " + defaultCount
					+ " times";
			log.info(message);
			Reporter.setCurrentTestResult(result);
			Reporter.log("RunCount=" + (defaultCount + 1));
			defaultCount++;
			return true;
		}
		return false;
	}

}
