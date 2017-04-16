package main.java.com.dbyl.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ReviewTest {
	static String ecoding = "utf8";

	/**
	 * n!
	 * 
	 * @author young
	 * @param n
	 * @return
	 */
	public static long factorial(int n) {
		if (n == 1 || n == 2) {
			return n;
		} else {
			return n * factorial(n - 1);
		}
	}

	public static void numbersSort() {
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				for (int k = 1; k <= 4; k++) {
					if (i != j && j != k && k != i) {
						System.out.println(i + "" + k + "" + j);
					}

				}
			}

		}
		System.out.println("Overall: " + A(4, 3));

	}

	/**
	 * n<=m
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	public static long C(int m, int n) {
		if (m != n) {
			return factorial(m) / (factorial(n) * factorial(m - n));
		} else {
			return factorial(m);
		}
	}

	/**
	 * n<=m
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	public static long A(int m, int n) {
		if (m != n) {
			return factorial(m) / factorial(m - n);
		} else {
			return 1;
		}
	}

	public static void main(String[] args) throws IOException {
		System.out.println("====>" + factorial(6));
		numbersSort();
		System.out.println("====>" + C(6, 4));
		String text = readTXT("/Volumes/Transcend/xiazai/love.txt");
		System.out.println("====>" + text);
		writeTXT("/Volumes/Transcend/xiazai/lesson1.txt", text);
	}

	/**
	 * @author young
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static String readTXT(String path) throws IOException {
		File file = new File(path);
		File file1 = new File(path+"_bak");
		FileInputStream stream;
		InputStreamReader reader = null;
		StringBuffer sb = new StringBuffer();
		BufferedReader bf = null;
		try {
			stream = new FileInputStream(file);
			reader = new InputStreamReader(stream, ecoding);
			bf = new BufferedReader(reader);
			String textLine = null;
			while ((textLine = bf.readLine()) != null) {
				sb.append(textLine + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			bf.close();
			reader.close();
		}

		FileReader fr=new FileReader(file);
		FileWriter fw=new FileWriter(file1);
		while(fr.read()!=-1)
		{
			int ch = fr.read(); 
			char c=(char) ch;
			System.out.println("%%%%%----+++>>>>"+c);
			fw.write(c);
		}
		fr.close();
		fw.close();
		return sb.toString();
	}

	public static void writeTXT(String path, String message) throws IOException {
		File file = new File(path);
		FileOutputStream stream = new FileOutputStream(file);
		OutputStreamWriter writer = new OutputStreamWriter(stream, ecoding);
		writer.append(message);
		// writer.write(message);
		writer.close();
		stream.close();

	}
}
