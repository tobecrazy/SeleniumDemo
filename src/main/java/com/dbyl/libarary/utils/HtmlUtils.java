package com.dbyl.libarary.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.dbyl.libarary.utils.beans.TestResultsBean;

public class HtmlUtils {

	public void generateHtmlSummary(TestResultsBean resultBean) throws IOException {
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
		String data = gson.toJson(resultBean);
		String html = sb.toString().replaceFirst("\\$\\{resultsJson\\}", data);

		FileWriter fileWritter = new FileWriter(new File("logs/template.html"), false);
		BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
		bufferWritter.write(html);
		bufferWritter.close();
	}

}
