package com.dbyl.tests.crawler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedHashSet;
import java.util.List;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import com.dbyl.libarary.utils.DatabaseUtils;
import com.dbyl.libarary.utils.StringTools;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class JobCrawler implements PageProcessor {
	private Site site = Site.me().setRetryTimes(3).setSleepTime(100);
	private static WebClient driver;
	static String code;
	static Connection conn;

	@Override
	public void process(Page page) {
		System.out.println("==============================================================");
		System.out.println("                              Start                           ");
		System.out.println("==============================================================");
		page.putField("name", page.getHtml().xpath("//span[@id='PROJECT_XMMC1']/text()").toString());
		page.putField("price", page.getHtml().xpath("//span[@id='lbYsZZJj']/text()").toString());
		page.putField("cdate", page.getHtml().xpath("//span[@id='PROJECT_JHJGRQ']/text()").toString());
		if (null == page.getResultItems().get("name")) {
			// skip this page
			page.setSkip(true);
		}

		if (null == page.getResultItems().get("price")) {
			// skip this page
			page.setSkip(true);
		}

		String name = page.getResultItems().get("name");
		float price = Float.parseFloat(page.getResultItems().get("price"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		try {
			name = new String(name.getBytes(), "utf-8");
		} catch (UnsupportedEncodingException e2) {
			e2.printStackTrace();
		}
		String tempDate = page.getResultItems().get("cdate");
		System.out.println("name: " + name + "===>" + price + "=====>" + tempDate+"\n");
		Date cdate = null;
		try {
			if (!StringTools.isNullOrEmpty(tempDate.trim())) {
				cdate = new Date(sdf.parse(tempDate.trim()).getTime());
			} else {
				cdate = new Date(System.currentTimeMillis());
			}
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		try {
			System.out.println("==============================================================");
			System.out.println("                    Insert To Database                        ");
			System.out.println("==============================================================");
			insertToDatabase(conn,StringTools.chineseToUnicode(name.trim()), price, cdate);
			writeToTXT(name.trim()+","+price+","+tempDate.trim()+"\n");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("==============================================================");
		System.out.println("                             The End                          ");
		System.out.println("==============================================================");
	}

	@Override
	public Site getSite() {
		return site;
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		conn = (new DatabaseUtils.Builder().setHost("WWW.WP.COM").setDbName("study").setUser("study")
				.setPassword("123456").builder()).getConection();
		for (String code : getAllLinks()) {
			String url = "http://www.lhfdc.gov.cn/templets/lh/aspx/hpms/ProjectInfo.aspx?code=" + code;
			System.out.println("=====>" + url);
			Spider.create(new JobCrawler()).addUrl(url).thread(1)
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
			String temp = StringTools.getMatch(source, "(\\d+)");
			System.out.println(temp);
			return temp;
		} else {
			return null;
		}

	}

	/**
	 * @author young
	 * @param conn
	 * @param name
	 * @param price
	 * @param cdate
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void insertToDatabase(Connection conn, String name, float price, Date cdate)
			throws ClassNotFoundException, SQLException {

		Date date = new Date(System.currentTimeMillis());
		PreparedStatement ps = conn.prepareStatement("INSERT into luohe(name,price,cdate) values (?, ?, ?)");

		ps.setString(1, name);
		ps.setFloat(2, price);
		ps.setDate(3, date);
		ps.executeUpdate();
		System.out.println("INSERT into luohe(name,price,cdate) values " + name + price + cdate);

	}
	public void writeToTXT(String message) throws IOException {
		BufferedWriter bf = null;
		try {
			// set true ,avoid
			bf = new BufferedWriter(new FileWriter("report1.csv", true));
			bf.write(message);
			bf.flush();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			bf.close();
		}


	}
}
