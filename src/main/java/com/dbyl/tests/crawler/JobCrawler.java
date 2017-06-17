package main.java.com.dbyl.tests.crawler;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.List;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import main.java.com.dbyl.libarary.utils.StringTools;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class JobCrawler implements PageProcessor {
	private Site site = Site.me().setRetryTimes(3).setSleepTime(100);
	private static WebClient driver;
	static String code;

	@Override
	public void process(Page page) {
		System.out.println("==============================================================");
		System.out.println("                              Start                           ");
		System.out.println("==============================================================");
		page.putField("name", page.getHtml().xpath("//span[@id='PROJECT_XMMC1']/text()").toString());
		page.putField("price", page.getHtml().xpath("//span[@id='lbYsZZJj']/text()").toString());
		if (null == page.getResultItems().get("name")) {
			// skip this page
			page.setSkip(true);
		}

		if (null == page.getResultItems().get("price")) {
			// skip this page
			page.setSkip(true);
		}
		System.out.println(page.getResultItems());

		System.out.println(page.getHtml().toString());
		System.out.println("==============================================================");
		System.out.println("                             The End                          ");
		System.out.println("==============================================================");
	}

	@Override
	public Site getSite() {
		return site;
	}

	public static void main(String[] args) throws IOException {

		for (String code : getAllLinks()) {
			String url = "http://www.lhfdc.gov.cn/templets/lh/aspx/hpms/ProjectInfo.aspx\\?code=" + code;
			Spider.create(new JobCrawler()).addUrl(url).thread(5)
					.addPipeline(new JsonFilePipeline("/Volumes/Transcend/Document/workspace/Demo/logs")).run();

		}

	}

	/**
	 * @author young
	 * @return
	 * @throws IOException
	 */
	public static LinkedHashSet<String> getAllLinks() throws IOException {
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
		return map;

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
