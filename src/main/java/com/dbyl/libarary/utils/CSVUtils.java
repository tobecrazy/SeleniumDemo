package com.dbyl.libarary.utils;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

/**
 * 
 * @author young
 *
 */
public class CSVUtils {
	/**
	 * @author young
	 * @param path
	 * @return
	 */
	public static String[][] CSVReader(String path) {
		return null;
	}

	/**
	 * @author young
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public boolean CSVWriter(String path) throws IOException {
		Reader in = new FileReader("path/to/file.csv");
		Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
		for (CSVRecord record : records) {
			String lastName = record.get("Last Name");
			String firstName = record.get("First Name");
		}

		return false;

	}

}
