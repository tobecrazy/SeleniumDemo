package main.java.com.dbyl.libarary.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class HtmlUtils {

	@Test
	public void generateHtmlSummary() throws IOException {
		File file = new File("data/HtmlReportTemplate.html");

		InputStream is = null;
		StringBuffer sb = new StringBuffer();
		try {
			is = new FileInputStream(file);
			int index = 0;
			byte[] b = new byte[1024];
			while ((index = is.read(b)) != -1) {
				sb.append(new String(b, 0, index));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		String data = "{" + 
				"	\"pass\": 1," + 
				"	\"failed\": 1," + 
				"	\"skip\": 1," + 
				"	\"testResult\": [{" + 
				"		\"caseId\": \"Test123\"," + 
				"		\"testName\": \"testDemo1\"," + 
				"		\"description\": \"测试DEMO1\"," + 
				"		\"spendTime\": \"12ms\"," + 
				"		\"status\": \"PASS\"," + 
				"		\"exception\": \"null\"," + 
				"		\"log\": \"Log Test  12dwfrferfgergergrt\"" + 
				"	}, {" + 
				"		\"caseId\": \"Test345\"," + 
				"		\"testName\": \"testDemo2\"," + 
				"		\"description\": \"测试DEMO2\"," + 
				"		\"spendTime\": \"15ms\"," + 
				"		\"status\": \"FAIL\"," + 
				"		\"exception\": \"bbbbb\"," + 
				"		\"log\": \"Log sssdsdfrfrfrgtrjutkikliolol.kumyjnytbrtgrtgfrf5\"" + 
				"	}, {" + 
				"		\"caseId\": \"Test769\"," + 
				"		\"testName\": \"testDemo\"," + 
				"		\"description\": \"测试DEMO\"," + 
				"		\"spendTime\": \"11ms\"," + 
				"		\"status\": \"SKIP\"," + 
				"		\"exception\": \"aaaaa\"," + 
				"		\"log\": \"Log Test tttttyyhyuuuykuikuiksdsdigf]'ekfefkpoegk[pegke[gwttttfrferfgergergrt\"" + 
				"	}]," + 
				"	\"total\": 3," + 
				"	\"startTime\": \"2018-06-09 13:27:44.917\"," + 
				"	\"totalTime\": \"38ms\"" + 
				"}";

		
		String html = sb.toString().replaceFirst("\\$\\{resultsJson\\}", gson.toJson(data)).replaceAll("\t", "");
		OutputStream htmlfile = new FileOutputStream(new File("logs/template.html"));
		PrintStream printhtml = new PrintStream(htmlfile);
		sb.append(html);
		printhtml.println(sb);
		printhtml.close();
	}

}
