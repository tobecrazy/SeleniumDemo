package com.dbyl.tests.qunar;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.dbyl.libarary.utils.DriverFactory;

public class TesseractTest {

	private static String from = "天津";
	private static String to = "广州";

	public static void main(String[] args) throws IOException,
			InterruptedException {

		WebDriver driver = DriverFactory.getFirefoxDriver();
		driver.get("http://flight.qunar.com/");
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		Actions actions = new Actions(driver);

		WebElement checkReturn = driver.findElement(By
				.xpath("//label[@for='searchTypeRnd']/input[@type='radio']"));
		checkReturn.click();
		WebElement checkSingle = driver.findElement(By
				.xpath("//label[@for='searchTypeSng']/input[@type='radio']"));
		checkSingle.click();

		WebElement fromCity = driver
				.findElement(By
						.xpath("//div[@id='js_flighttype_tab_domestic']//input[@class='textbox' and @name='fromCity']"));

		WebElement toCity = driver
				.findElement(By
						.xpath("//div[@id='js_flighttype_tab_domestic']//input[@class='textbox' and @name='toCity']"));
		WebElement flightDay = driver
				.findElement(By
						.xpath("//div[@id='js_flighttype_tab_domestic']//input[@class='textbox' and @name='fromDate']"));

		fromCity.clear();
		fromCity.sendKeys(from);

		toCity.clear();
		toCity.sendKeys(to);

		flightDay.clear();
		flightDay.sendKeys("2015-08-25");
		WebElement searchButton = driver
				.findElement(By
						.xpath("//div[@id='js_flighttype_tab_domestic']//div[@class='crl_sp_action']/button[@class='btn_search']"));
		searchButton.submit();

		// take screen shot for element
		screenShotForElement(driver, fromCity, "D:\\Tesseract-OCR\\test.png");

		// driver.quit();

		// use Tesseract to get strings
		Runtime rt = Runtime.getRuntime();
		rt.exec("cmd.exe /C  tesseract.exe D:\\Tesseract-OCR\\test.png  D:\\Tesseract-OCR\\test -1 ");

		Thread.sleep(1000);
		// Read text
		readTextFile("D:\\Tesseract-OCR\\test.txt");
	}

	/**
	 * This method for read TXT file
	 * 
	 * @param filePath
	 */
	public static void readTextFile(String filePath) {
		try {
			String encoding = "GBK";
			File file = new File(filePath);
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					System.out.println(lineTxt);
				}
				read.close();
			} else {
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
	}

	/**
	 * This method for screen shot element
	 * 
	 * @param driver
	 * @param element
	 * @param path
	 * @throws InterruptedException
	 */
	public static void screenShotForElement(WebDriver driver,
			WebElement element, String path) throws InterruptedException {
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		try {
			Point p = element.getLocation();
			int width = element.getSize().getWidth();
			int height = element.getSize().getHeight();
			Rectangle rect = new Rectangle(width, height);
			BufferedImage img = ImageIO.read(scrFile);
			BufferedImage dest = img.getSubimage(p.getX(), p.getY(),
					rect.width, rect.height);
			ImageIO.write(dest, "png", scrFile);
			Thread.sleep(1000);
			FileUtils.copyFile(scrFile, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getSomeDayAfterToday(int someDaysAfterToday) {
		
		Calendar cal= Calendar.getInstance();
		return null;
	}

}
