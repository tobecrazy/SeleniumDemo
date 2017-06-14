package main.java.com.dbyl.tests.crawler;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class JobCrawler implements PageProcessor {

	private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

	@Override
	public void process(Page page) {
		System.out.println("==============================================================");
		System.out.println("                              Start                           ");
		System.out.println("==============================================================");
		page.addTargetRequests(page.getHtml().xpath("//table[@class='listC']//td/a").links()
				.regex("(http://www.lhfdc.gov.cn/templets/lh/aspx/hpms/ProjectInfo.aspx\\?code=\\d+.)").all());
		page.putField("name", page.getHtml().xpath("//span[@id='PROJECT_XMMC1']/text()").toString());
		if (page.getResultItems().get("name") == null) {
			// skip this page
			page.setSkip(true);
		}
		page.getRawText();
		page.putField("nextPage", page.getHtml().xpath("//a[@id='PageNavigator1_LnkBtnNext']"));
	
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

	public static void main(String[] args) {
		Spider.create(new JobCrawler()).addUrl("http://www.lhfdc.gov.cn/templets/lh/aspx/hpms/ProjectList.aspx")
				.thread(1) .addPipeline(new JsonFilePipeline("/Volumes/Transcend/Document/workspace/Demo/logs")).run();
	}

}
