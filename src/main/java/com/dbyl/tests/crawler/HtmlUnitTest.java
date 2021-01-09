package com.dbyl.tests.crawler;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.LinkedHashSet;
import java.util.List;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import com.dbyl.libarary.utils.StringTools;

public class HtmlUnitTest {

	private static WebClient driver;
	static String code;

	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		driver = new WebClient(BrowserVersion.CHROME);
		HtmlPage page = driver.getPage("http://www.lhfdc.gov.cn/templets/lh/aspx/hpms/ProjectList.aspx");
		LinkedHashSet<String> map = new LinkedHashSet<String>();

		DomElement button = page.getFirstByXPath("//a[@id='PageNavigator1_LnkBtnNext' and not(@disabled)]");
		List<?> target = page.getByXPath("//table[@class='listC']//td/a");

		for (Object link : target) {

			code = getCode(link.toString());
			map.add(code);
		}
		int i = 0;
		while (null != page) {
			i++;
			System.out.println("============>" + i);
			button = page.getFirstByXPath("//a[@id='PageNavigator1_LnkBtnNext' and not(@disabled)]");
			if (null == button) {
				break;
			} else {
				page = button.click();
				target = null;
				target = page.getByXPath("//table[@class='listC']//td/a");
				for (Object link : target) {
					code = getCode(link.toString());
					map.add(code);
				}
			}
		}

		System.out.println(map.size());

	}

	/**
	 * @author young
	 * @param source
	 * @return
	 */
	public static String getCode(String source) {
		if (null != source) {
			return StringTools.getMatch(source, "\\d+");
		} else {
			return null;
		}

	}
}
