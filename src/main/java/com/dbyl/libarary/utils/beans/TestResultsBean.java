package com.dbyl.libarary.utils.beans;

import java.util.Date;
import java.util.List;

/**
 * The Class TestResultsBean.
 * @author Young
 */
public class TestResultsBean {
	    
    	/** The pass. */
    	private int pass;
	    
    	/** The failed. */
    	private int failed;
	    
    	/** The skip. */
    	private int skip;
	    
    	/** The test result. */
    	private List<TestResult> testResult;
	    
    	/** The total. */
    	private int total;
	    
    	/** The start time. */
    	private Date startTime;
	    
    	/** The total time. */
    	private String totalTime;
	    
    	/**
    	 * Sets the pass.
    	 *
    	 * @param pass the new pass
    	 */
    	public void setPass(int pass) {
	         this.pass = pass;
	     }
	     
     	/**
     	 * Gets the pass.
     	 *
     	 * @return the pass
     	 */
     	public int getPass() {
	         return pass;
	     }

	    /**
    	 * Sets the failed.
    	 *
    	 * @param failed the new failed
    	 */
    	public void setFailed(int failed) {
	         this.failed = failed;
	     }
	     
     	/**
     	 * Gets the failed.
     	 *
     	 * @return the failed
     	 */
     	public int getFailed() {
	         return failed;
	     }

	    /**
    	 * Sets the skip.
    	 *
    	 * @param skip the new skip
    	 */
    	public void setSkip(int skip) {
	         this.skip = skip;
	     }
	     
     	/**
     	 * Gets the skip.
     	 *
     	 * @return the skip
     	 */
     	public int getSkip() {
	         return skip;
	     }

	    /**
    	 * Sets the test result.
    	 *
    	 * @param testResult the new test result
    	 */
    	public void setTestResult(List<TestResult> testResult) {
	         this.testResult = testResult;
	     }
	     
     	/**
     	 * Gets the test result.
     	 *
     	 * @return the test result
     	 */
     	public List<TestResult> getTestResult() {
	         return testResult;
	     }

	    /**
    	 * Sets the total.
    	 *
    	 * @param total the new total
    	 */
    	public void setTotal(int total) {
	         this.total = total;
	     }
	     
     	/**
     	 * Gets the total.
     	 *
     	 * @return the total
     	 */
     	public int getTotal() {
	         return total;
	     }

	    /**
    	 * Sets the start time.
    	 *
    	 * @param startTime the new start time
    	 */
    	public void setStartTime(Date startTime) {
	         this.startTime = startTime;
	     }
	     
     	/**
     	 * Gets the start time.
     	 *
     	 * @return the start time
     	 */
     	public Date getStartTime() {
	         return startTime;
	     }

	    /**
    	 * Sets the total time.
    	 *
    	 * @param totalTime the new total time
    	 */
    	public void setTotalTime(String totalTime) {
	         this.totalTime = totalTime;
	     }
	     
     	/**
     	 * Gets the total time.
     	 *
     	 * @return the total time
     	 */
     	public String getTotalTime() {
	         return totalTime;
	     }

	 

}
