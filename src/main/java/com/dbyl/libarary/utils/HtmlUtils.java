package main.java.com.dbyl.libarary.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.testng.annotations.Test;

public class HtmlUtils {
	StringBuffer sb = new StringBuffer();

	@Test
	public void generateHtmlSummary() throws IOException {
		File input = new File("logs/report.html");
		Document doc = Jsoup.parse(input, "UTF-8");
		System.out.println(doc.toString());
		OutputStream htmlfile = new FileOutputStream(new File("logs/report.html"));
		PrintStream printhtml = new PrintStream(htmlfile);
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>");
		sb.append("Test Report");
		sb.append("</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<h1>Test</h1>");
		sb.append("</body>");
		sb.append("</html>");
		printhtml.println(sb);
		printhtml.close();
	}

}
