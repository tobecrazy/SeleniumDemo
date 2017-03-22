package main.java.com.dbyl.libarary.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.IExecutionListener;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

/**
 * 
 * @author young
 *
 */
public class ImplTestNGListener implements IExecutionListener, ITestListener, IInvokedMethodListener {
	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Log log = new Log(this.getClass());

	@Override
	public void onExecutionStart() {
		log.info("================On Execute Start======================");
		Date start = new Date();
		log.info("================" + sf.format(start) + " ======================");

	}

	@Override
	public void onExecutionFinish() {
		// TODO Auto-generated method stub
		log.info("================On Execute finish======================");
		Date end = new Date();
		log.info("================" + sf.format(end) + " ======================");

	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("================On Test Start======================");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("================On Test Success======================");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("================On Test failure======================");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("================On test skip======================");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		Date date1 = context.getStartDate();
		log.info("================" + sf.format(date1) + " ======================");
		log.info("================On **** Start======================");

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		Date date2 = context.getStartDate();
		log.info("================" + sf.format(date2) + " ======================");
		log.info("================On ***Finish ======================");

	}

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub
		log.info("Before Invocation Method");
		ITestNGMethod methods = method.getTestMethod();

		String[] groups = methods.getGroups();
		for (String group : groups) {
			log.info("----------------Invoked Test Group-------------");
			log.debug(group);
			log.info("---------------------------------------");
		}

	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub
		log.info("After Invocation Method");

	}

}
