package main.java.com.dbyl.tests.crawler;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
public class HtmlUnitTest {

	private static WebClient driver;

	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		driver = new WebClient();
		HtmlPage page = driver.getPage("http://www.lhfdc.gov.cn/templets/lh/aspx/hpms/ProjectList.aspx");

        //get list of all divs
        final List<?> links = page.getByXPath("//table[@class='listC']//td/a");
        for(Object link:links)
        {
        	System.out.println(link.toString());
        }
         

	}

}
