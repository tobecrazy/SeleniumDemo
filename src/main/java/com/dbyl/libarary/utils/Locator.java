package com.dbyl.libarary.utils;

/**
 * This is for element library
 * 
 * @author Young
 *
 */
public class Locator {
	private String element;

	// default is 5 sec
	private int waitSec = 5;

	/**
	 * create a enum variable for By
	 * 
	 * @author Young
	 *
	 */
	public enum ByType {
		xpath, id, linkText, name, className, cssSelector, partialLinkText, tagName
	}

	private ByType byType;

	public Locator() {

	}

	/**
	 * defaut Locator ,use Xpath
	 * 
	 * @author Young
	 * @param element
	 */
	public Locator(String element) {
		this.element = element;
		this.waitSec = 3;
		this.byType = ByType.xpath;
	}

	public Locator(String element, int waitSec) {
		this.waitSec = waitSec;
		this.element = element;
		this.byType = ByType.xpath;
	}

	public Locator(String element, int waitSec, ByType byType) {
		this.waitSec = waitSec;
		this.element = element;
		this.byType = byType;
	}

	public String getElement() {
		return element;
	}

	public int getWaitSec() {
		return waitSec;
	}

	public ByType getBy() {
		return byType;
	}

	public void setBy(ByType byType) {
		this.byType = byType;
	}

	public void setReplace(String rep, String rex) {
		StringTools.replaceAll(element, rex, rep);
	}
}
