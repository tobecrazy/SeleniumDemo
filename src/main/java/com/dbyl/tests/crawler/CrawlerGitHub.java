package com.dbyl.tests.crawler;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class CrawlerGitHub implements PageProcessor {
	private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

	public static void main(String[] args) {

		Spider.create(new CrawlerGitHub()).addUrl("https://github.com/tobecrazy").thread(1).run();
	}

	@Override
	public void process(Page page) {

		page.putField("name", page.getHtml().xpath(("//span[@class='repo js-repo']/text()")).toString());
		if (page.getResultItems().get("name") == null) {
			// skip this page
			page.setSkip(true);
		}
		System.out.println(page.getHtml());
	}

	@Override
	public Site getSite() {
		return site;
	}

}
