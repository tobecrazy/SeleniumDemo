package com.dbyl.tests.training.day5;


import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver driver;
	// protected String[][] locatorMap;
	HashMap<String, Locator> locatorMap;
	String path;

	protected BasePage(WebDriver driver) throws Exception {
		this.driver = driver;
		// locatorMap = ReadExcelUtil.getLocatorMap();
		path = System.getProperty("user.dir") + "/src/Test/day5/" + this.getClass().getSimpleName() + ".xml";
		locatorMap = XMLUtils.readXMLDocument(path, this.getClass().getCanonicalName());
	}

	protected void type(Locator locator, String values) throws Exception {
		WebElement e = findElement(driver, locator);
		e.sendKeys(values);
	}

	/**
	 * This Method is for set value use javascript
	 * 
	 * @author Young
	 * @param locator
	 * @param values
	 * @throws Exception
	 */
	protected void typeQuick(Locator locator, String values) throws Exception {
		WebElement e = findElement(driver, locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value=\"" + values + "\"", e);

	}

	/**
	 * @author Young
	 * @param locator
	 * @param text
	 */
	protected void setRichTextBox(Locator locator, String text) {
		WebElement e = findElement(driver, locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].innerHTML = \"" + text + "\"", e);
	}

	/**
	 * fix get richText value
	 * 
	 * @author Young
	 * @param locator
	 * @param text
	 * @return
	 */
	protected String getRichTextBox(Locator locator, String text) {
		WebElement e = findElement(driver, locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String result = (String) js.executeScript("var result=arguments[0].innerHTML;return result ", e);
		return result;
	}

	/**
	 * @author Young
	 * @param locator
	 */
	protected void scrollToElement(Locator locator) {
		WebElement e = findElement(driver, locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// roll down and keep the element to the center of browser
		js.executeScript("arguments[0].scrollIntoViewIfNeeded(true);", e);
	}

	protected void click(Locator locator) throws Exception {
		WebElement e = findElement(driver, locator);
		e.click();
	}

	protected void select(Locator locator, String value) throws Exception {
		WebElement e = findElement(driver, locator);
		Select select = new Select(e);

		try {
			select.selectByValue(value);
		} catch (Exception notByValue) {
			select.selectByVisibleText(value);
		}
	}

	protected void alertConfirm() {
		Alert alert = driver.switchTo().alert();
		try {
			alert.accept();
		} catch (Exception notFindAlert) {
			throw notFindAlert;
		}
	}

	protected void alertDismiss() {
		Alert alert = driver.switchTo().alert();
		try {
			alert.dismiss();
		} catch (Exception notFindAlert) {
			throw notFindAlert;
		}
	}

	protected String getAlertText() {
		Alert alert = driver.switchTo().alert();
		try {
			return alert.getText();
		} catch (Exception notFindAlert) {
			throw notFindAlert;
		}
	}

	protected void clickAndHold(Locator locator) throws IOException {
		WebElement e = findElement(driver, locator);
		Actions actions = new Actions(driver);
		actions.clickAndHold(e).perform();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(Locator locator) throws IOException {
		return getElement(this.getDriver(), locator);
	}

	/**
	 * get by parameter
	 * 
	 * @author Young
	 * @param driver
	 * @param locator
	 * @return
	 * @throws IOException
	 */
	public WebElement getElement(WebDriver driver, Locator locator) throws IOException {
		locator = getLocator(locator.getElement());
		WebElement e;
		switch (locator.getBy()) {
		case xpath:
			e = driver.findElement(By.xpath(locator.getElement()));
			break;
		case id:
			e = driver.findElement(By.id(locator.getElement()));
			break;
		case name:
			e = driver.findElement(By.name(locator.getElement()));
			break;
		case cssSelector:
			e = driver.findElement(By.cssSelector(locator.getElement()));
			break;
		case className:
			e = driver.findElement(By.className(locator.getElement()));
			break;
		case tagName:
			e = driver.findElement(By.tagName(locator.getElement()));
			break;
		case linkText:
			e = driver.findElement(By.linkText(locator.getElement()));
			break;
		case partialLinkText:
			e = driver.findElement(By.partialLinkText(locator.getElement()));
			break;
		default:
			e = driver.findElement(By.id(locator.getElement()));
		}
		return e;
	}

	/**
	 * 
	 * @param driver
	 * @param myLocator
	 * @param timeOut
	 * @return
	 * @throws IOException
	 */
	public boolean isElementPresent(WebDriver driver, Locator myLocator, int timeOut) throws IOException {
		final Locator locator = getLocator(myLocator.getElement());
		boolean isPresent = false;
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement e = wait.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver d) {
				try {
					return findElement(d, locator);
				} catch (NoSuchElementException e) {
					return null;
				}
			}
		});
		if (e != null) {
			isPresent = e.isDisplayed();
		}

		return isPresent;
	}

	/**
	 * This Method for check isPresent Locator
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 * @throws IOException
	 */
	public boolean isElementPresent(Locator locator, int timeOut) throws IOException {
		return isElementPresent(driver, locator, timeOut);
	}

	/**
	 * 
	 * @param driver
	 * @param locator
	 * @return
	 */
	public WebElement findElement(WebDriver driver, final Locator locator) {
		WebElement element = (new WebDriverWait(driver, locator.getWaitSec()))
				.until(new ExpectedCondition<WebElement>() {

					@Override
					public WebElement apply(WebDriver driver) {
						try {
							return getElement(driver, locator);
						} catch (IOException e) {
							return null;
						}

					}

				});
		return element;

	}

	/**
	 * @author Young
	 * 
	 * @param locatorName
	 * @return
	 * @throws IOException
	 */
	public Locator getLocator(String locatorName) throws IOException {

		Locator locator = new Locator(locatorName);
		if (locatorMap != null) {
			locator = locatorMap.get(locatorName);
		}
		return locator;
	}

	/**
	 * For DOM Event
	 * 
	 * @author Young
	 * @param locator
	 * @param event
	 *            please refer to:
	 *            http://www.w3school.com.cn/jsref/dom_obj_event.asp
	 * 
	 */
	public void DOMEvent(Locator locator, String event) {
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		String js = "var event;if (document.createEvent){event = document.createEvent(\"HTMLEvents\");event.initEvent(\""
				+ event + "\", true, false);arguments[0].dispatchEvent(event);} else {arguments[0].fireEvent(\"on"
				+ event + "\")}";
		jse.executeScript(js, findElement(driver, locator));
	}

	/**
	 * get Text
	 * 
	 * @author young
	 * @param locator
	 * @return
	 */
	public String getText(Locator locator) {
		WebElement e = findElement(driver, locator);
		return e.getText();
	}

}
