package com.dbyl.libarary.listeners;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.testng.IExecutionListener;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import com.dbyl.libarary.utils.HtmlUtils;
import com.dbyl.libarary.utils.LogUtils;
import com.dbyl.libarary.utils.beans.TestResult;
import com.dbyl.libarary.utils.beans.TestResultsBean;

/**
 * 
 * @author young
 * @version V1.0
 */
public class ImplTestNGListener implements IExecutionListener, ITestListener, IInvokedMethodListener {
	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	LogUtils log = new LogUtils(this.getClass());
	Long startTime;
	Long endTime;
	int passNumber = 0;
	int failedNumber = 0;
	int skipNumber = 0;
	List<TestResult> testResults = new ArrayList<TestResult>();
	TestResultsBean resultBean = new TestResultsBean();
	Date start = new Date();
	Long methodStartTime;
	Long methodEndTime;

	@Override
	public void onExecutionStart() {
		log.info("================On Execute Start======================");

		startTime = System.currentTimeMillis();
		log.info("================" + sf.format(start) + " ======================");

	}

	@Override
	public void onExecutionFinish() {
		log.info("================On Execute finish======================");
		Date end = new Date();
		endTime = System.currentTimeMillis();

		log.info("================" + sf.format(end) + " ======================");
		log.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		log.info("================" + String.valueOf(endTime - startTime) + " ======================");
		log.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		log.debug("Pass " + passNumber);
		log.debug("Fail " + failedNumber);
		log.debug("skip " + skipNumber);
		resultBean.setPass(passNumber);
		resultBean.setFailed(failedNumber);
		resultBean.setSkip(skipNumber);
		resultBean.setTestResult(testResults);
		resultBean.setStartTime(start);
		resultBean.setTotal(failedNumber + failedNumber + skipNumber);
		HtmlUtils html = new HtmlUtils();
		try {
			html.generateHtmlSummary(resultBean);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onTestStart(ITestResult result) {
		log.info("================On Test Start======================");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		log.info("================On Test Success======================");
		passNumber += 1;
		TestResult testResult = new TestResult();
		testResult.setCaseId(result.getName());
		testResult.setDescription(result.getMethod().getDescription());
		testResult.setStatus("PASS");
		testResult.setTestName(result.getInstanceName());
		StringBuffer sb = new StringBuffer();
		try {
			StackTraceElement[] ste = result.getThrowable().getStackTrace();
			for (StackTraceElement st : ste) {
				log.warn(st.toString());
				sb.append(st.toString());
				sb.append("<br>");
			}
		} catch (Exception e) {
			sb.append("<br>");
		}

		testResults.add(testResult);

	}

	@Override
	public void onTestFailure(ITestResult result) {
		log.info("================On Test failure======================");
		failedNumber += 1;
		TestResult testResult = new TestResult();
		testResult.setCaseId(result.getName());
		testResult.setDescription(result.getMethod().getDescription());
		testResult.setStatus("FAIL");
		testResult.setTestName(result.getInstanceName());
		log.info("###################################################################");
		// result.getThrowable().printStackTrace();
		StringBuffer sb = new StringBuffer();
		StackTraceElement[] ste = result.getThrowable().getStackTrace();
		for (StackTraceElement st : ste) {
			log.warn(st.toString());
			sb.append(st.toString());
			sb.append("<br>");
		}
		testResult.setLog(sb.toString());
		log.warn(result.getThrowable().getMessage());
		log.info("###################################################################");
		log.info("=====>" + result.getInstanceName() + " ***** " + result.getName());
		testResult.setException(result.getThrowable().getMessage());
		testResults.add(testResult);

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		log.info("================On test skip======================");
		skipNumber += 1;
		TestResult testResult = new TestResult();
		testResult.setCaseId(result.getName());
		testResult.setDescription(result.getMethod().getDescription());
		testResult.setStatus("SKIP");
		testResult.setTestName(result.getInstanceName());
		StringBuffer sb = new StringBuffer();
		StackTraceElement[] ste = result.getThrowable().getStackTrace();
		for (StackTraceElement st : ste) {
			log.warn(st.toString());
			sb.append(st.toString());
			sb.append("<br>");
		}
		testResult.setLog(sb.toString());
		testResults.add(testResult);

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		Date date1 = context.getStartDate();
		log.info("================" + sf.format(date1) + " ======================");
		log.info("================On **** Start======================");
		methodStartTime = System.currentTimeMillis();

	}

	@Override
	public void onFinish(ITestContext context) {
		Date date2 = context.getEndDate();
		log.info("================" + sf.format(date2) + " ======================");
		log.info("================On ***Finish ======================");
		methodEndTime = System.currentTimeMillis();
		log.error("@@@@@@@@@@ " + String.valueOf(methodEndTime - methodStartTime));

	}

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
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
		log.info("After Invocation Method");

	}

}
