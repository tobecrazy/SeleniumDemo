package com.dbyl.libarary.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.function.Function;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author young
 *
 */
public class BasePage {

	protected WebDriver driver;
	// protected String[][] locatorMap;
	HashMap<String, Locator> locatorMap;
	String path;
	protected LogUtils log = new LogUtils(this.getClass());

	protected BasePage(WebDriver driver) throws Exception {
		this.driver = driver;
		log.debug(this.getClass().getCanonicalName());
		log.info(System.getProperty("user.dir"));
		// locatorMap = ReadExcelUtil.getLocatorMap();
		path = System.getProperty("user.dir") + "/src/main/java/com/dbyl/libarary/pageAction/" + this.getClass().getSimpleName()
				+ ".xml";
		log.info(path);
		locatorMap = XMLUtils.readXMLDocument(path, this.getClass().getCanonicalName());
	}

	protected void type(Locator locator, String values) throws Exception {
		WebElement e = findElement(driver, locator);
		log.info("type value is:  " + values);
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
		log.info("type value is:  " + values);
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
		log.info("type value is:  " + text);
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
		log.info("type value is:  " + text);
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
		log.info("scroll view element");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// roll down and keep the element to the center of browser
		js.executeScript("arguments[0].scrollIntoViewIfNeeded(true);", e);
	}

	protected void click(Locator locator) throws Exception {
		WebElement e = findElement(driver, locator);
		log.info("click button");
		e.click();
	}

	protected void select(Locator locator, String value) throws Exception {
		WebElement e = findElement(driver, locator);
		Select select = new Select(e);

		try {
			log.info("select by Value " + value);
			select.selectByValue(value);
		} catch (Exception notByValue) {
			log.info("select by VisibleText " + value);
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
	 * @param sourcelocator
	 * @return
	 * @throws IOException
	 */
	public WebElement getElement(WebDriver driver, Locator sourceLocator) throws IOException {
		Locator locator = getLocator(sourceLocator.getElement());
		// this code fix can't get locator from page XML issue
		if (locator == null) {
			locator = new Locator(sourceLocator.getElement(), sourceLocator.getWaitSec(), sourceLocator.getBy());
		}
		WebElement e;
		switch (locator.getBy()) {
		case xpath:
			log.debug("find element By xpath");
			e = driver.findElement(By.xpath(locator.getElement()));
			break;
		case id:
			log.debug("find element By id");
			e = driver.findElement(By.id(locator.getElement()));
			break;
		case name:
			log.debug("find element By name");
			e = driver.findElement(By.name(locator.getElement()));
			break;
		case cssSelector:
			log.debug("find element By cssSelector");
			e = driver.findElement(By.cssSelector(locator.getElement()));
			break;
		case className:
			log.debug("find element By className");
			e = driver.findElement(By.className(locator.getElement()));
			break;
		case tagName:
			log.debug("find element By tagName");
			e = driver.findElement(By.tagName(locator.getElement()));
			break;
		case linkText:
			log.debug("find element By linkText");
			e = driver.findElement(By.linkText(locator.getElement()));
			break;
		case partialLinkText:
			log.debug("find element By partialLinkText");
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
		WebElement e = wait.until(new Function<WebDriver, WebElement>(){
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
		int timeOut = 60;
		if (locator != null) {
			try {
				timeOut = locator.getWaitSec();
			} catch (NullPointerException e) {
				log.error("can't get Default time out " + locator.getElement());
			}

			WebElement element = (new WebDriverWait(driver, timeOut)).until(new Function<WebDriver, WebElement>() {

				@Override
				public WebElement apply(WebDriver driver) {
					try {
						return getElement(driver, locator);
					} catch (IOException e) {
						log.error("can't find element " + locator.getElement());
						return null;
					}

				}

			});
			return element;

		} else {
			return null;
		}

	}

	/**
	 * @author young
	 * @param locatorName
	 * @return
	 * @throws IOException
	 */
	public Locator getLocator(String locatorName) throws IOException {

		Locator locator = new Locator(locatorName);
		// for (int i = 0; i < locatorMap.length; i++) {
		// if (locatorMap[i][0].endsWith(locatorName)) {
		// return locator = new Locator(locatorMap[i][1]);
		// }
		// }
		// return locator = new Locator(locatorName);
		if (locatorMap != null) {
			locator = locatorMap.get(locatorName);
		} else {
			locator = new Locator(locatorName);
		}
		return locator;
	}

	public int open(String URL) {
		if (URL == null || URL.equals("")) {
			log.error("invlid URL");
			return -1;
		}
		int responseStatus = 200;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			// 创建httpget.
			HttpGet httpget = new HttpGet(URL);
			log.info("executing request " + httpget.getURI());
			// 执行get请求.
			CloseableHttpResponse response = httpclient.execute(httpget);
			try {
				// 获取响应实体
				HttpEntity entity = response.getEntity();
				log.info("--------------------------------------");
				// 打印响应状态
				log.info(response.getStatusLine().toString());
				if (entity != null) {
					// 打印响应内容长度
					log.info("Response content length: " + entity.getContentLength());
					// 打印响应内容
					log.info("Response content: " + EntityUtils.toString(entity));
				}
				log.info("------------------------------------");
			} finally {
				response.close();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return responseStatus;
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
	 * for get Text
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
