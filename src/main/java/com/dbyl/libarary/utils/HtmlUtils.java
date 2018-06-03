package main.java.com.dbyl.libarary.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class HtmlUtils {
	StringBuffer sb = new StringBuffer();

	@Test
	public void generateHtmlSummary() throws IOException {
		File input = new File("data/Template.html");
		Document doc = Jsoup.parse(input, "UTF-8");
//		Element report = doc.getElementById("reportName");
//		report.append("aaaddd");
//		Element name = doc.getElementById("name");
//		name.text("Test1133");
//		Element total = doc.getElementById("total");
//		total.text("100");
//		Element passed = doc.getElementById("passed");
//		passed.text("78");
//		Element failed = doc.getElementById("failed");
//		failed.text("21");
//		Element skipped = doc.getElementById("skipped");
//		skipped.text("1");
//		HashMap<String, String> resultData = new HashMap<String, String>();
//		resultData.put("name", "aaaddd");
//		resultData.put("total", "100");
//		resultData.put("passed", "78");
//		resultData.put("failed", "21");
//		resultData.put("skipped", "1");
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		String data="{" + 
				"    \"testPass\": 1," + 
				"    \"testResult\": [" + 
				"        {" + 
				"            \"className\": \"com.test.testcase.TestDemo1\"," + 
				"            \"methodName\": \"testDemo\"," + 
				"            \"description\": \"测试DEMO\"," + 
				"            \"spendTime\": \"11ms\"," + 
				"            \"status\": \"成功\"," + 
				"            \"log\": [" + 
				"                \"this is demo!\"" + 
				"            ]" + 
				"        }" + 
				"    ]," + 
				"    \"testName\": \"20171109132744897\"," + 
				"    \"testAll\": 1," + 
				"    \"testFail\": 0," + 
				"    \"beginTime\": \"2017-11-09 13:27:44.917\"," + 
				"    \"totalTime\": \"11ms\"," + 
				"    \"testSkip\": 0" + 
				"}";
 
		String html = doc.html().replaceFirst("\\$\\{resultData\\}", gson.toJson(data));
		System.out.println(doc.html());
		OutputStream htmlfile = new FileOutputStream(new File("logs/template.html"));
		PrintStream printhtml = new PrintStream(htmlfile);
		sb.append(html);
		printhtml.println(sb);
		printhtml.close();

		FileOutputStream fos = new FileOutputStream("logs/report.html", false);
		OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
		osw.write(doc.html());
		osw.close();
	}
	
	private String getStatus(int status) {
		String statusString = null;
		switch (status) {
		case 1:
			statusString = "成功";
			break;
		case 2:
			statusString = "失败";
			break;
		case 3:
			statusString = "跳过";
			break;
		default:
			break;
		}
		return statusString;
	}
	
	public static class ReportInfo {
		
		private String name;
		
		private String className;
	
		private String methodName;
		
		private String description;
		
		private String spendTime;
				
		private String status;
		
		private List<String> log;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getClassName() {
			return className;
		}

		public void setClassName(String className) {
			this.className = className;
		}

		public String getMethodName() {
			return methodName;
		}

		public void setMethodName(String methodName) {
			this.methodName = methodName;
		}

		public String getSpendTime() {
			return spendTime;
		}

		public void setSpendTime(String spendTime) {
			this.spendTime = spendTime;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public List<String> getLog() {
			return log;
		}

		public void setLog(List<String> log) {
			this.log = log;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}
		
	}
	

}
