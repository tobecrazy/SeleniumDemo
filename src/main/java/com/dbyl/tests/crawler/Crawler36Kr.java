package com.dbyl.tests.crawler;

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.monitor.SpiderMonitor;
import us.codecraft.webmagic.pipeline.PageModelPipeline;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.ExtractByUrl;
import us.codecraft.webmagic.model.annotation.HelpUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;

import javax.management.JMException;
import java.io.IOException;

/**
 * @author young
 */
@TargetUrl("http://www.36kr.com/p/\\d+.html")
@HelpUrl("http://www.36kr.com/#/page/\\d+")
public class Crawler36Kr {

	@ExtractBy("//h1[@class='entry-title sep10']")
	private String title;

	@ExtractBy("//div[@class='mainContent sep-10']/tidyText()")
	private String content;

	@ExtractByUrl
	private String url;

	public static void main(String[] args) throws IOException, JMException {
		// Just for benchmark
		Spider thread = OOSpider.create(Site.me().setSleepTime(0), new PageModelPipeline() {
			@Override
			public void process(Object o, Task task) {

			}
		}, Crawler36Kr.class).thread(20).addUrl("http://www.36kr.com/");
		thread.start();
		SpiderMonitor spiderMonitor = SpiderMonitor.instance();
		spiderMonitor.register(thread);
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getUrl() {
		return url;
	}
}
