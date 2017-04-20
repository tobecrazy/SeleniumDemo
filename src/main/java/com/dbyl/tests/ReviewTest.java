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
		// System.out.println("====>" + GetIndex("abCDfYxzzxc", "CD"));
		int[] array = new int[] { 1, 3, 4, 2, 0 };
		SelectionSort(array);
		// BubbleSort(array);

		// System.out.println("====>" + factorial(6));
		// numbersSort();
		// System.out.println("====>" + C(6, 4));
		// String text = readTXT("/Volumes/Transcend/xiazai/love.txt");
		// System.out.println("====>" + text);
		// writeTXT("/Volumes/Transcend/xiazai/lesson1.txt", text);
	}

	/**
	 * @author young
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static String readTXT(String path) throws IOException {
		File file = new File(path);
		File file1 = new File(path + "_bak");
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

		FileReader fr = new FileReader(file);
		FileWriter fw = new FileWriter(file1);
		while (fr.read() != -1) {
			int ch = fr.read();
			char c = (char) ch;
			System.out.println("%%%%%----+++>>>>" + c);
			fw.write(c);
		}
		fr.close();
		fw.close();
		return sb.toString();
	}

	/**
	 * 
	 * @param source
	 * @param key
	 * @return
	 */
	public static int KMP(String source, String key) {

		char[] sourceTemp = source.toCharArray();
		char[] keyTemp = key.toCharArray();
		for (int i = 0; i < sourceTemp.length - keyTemp.length + 1; i++) {
			int count = 0;
			for (int j = 0; j < keyTemp.length; j++) {
				if (sourceTemp[i + j] == keyTemp[j]) {
					count++;
					continue;
				}
			}
			if (count == keyTemp.length) {
				return i;
			}
		}

		return -1;
	}

	public static int GetIndex(String source, String key) {
		return source.indexOf(key);
	}

	/**
	 * @author young
	 * @param path
	 * @param message
	 * @throws IOException
	 */
	public static void writeTXT(String path, String message) throws IOException {
		File file = new File(path);
		FileOutputStream stream = new FileOutputStream(file);
		OutputStreamWriter writer = new OutputStreamWriter(stream, ecoding);
		writer.append(message);
		// writer.write(message);
		writer.close();
		stream.close();
	}

	/**
	 * @author young
	 * @param source
	 */
	public static void BubbleSort(int[] source) {
		int temp;
		for (int i = 0; i < source.length - 1; i++) {

			for (int j = 0; j < source.length - i - 1; j++) {
				if (source[j] > source[j + 1]) {
					temp = source[j];
					source[j] = source[j + 1];
					source[j + 1] = temp;
				}
			}
		}
		for (int target : source) {
			System.out.println(">>>>" + target);
		}
	}

	/**
	 * @author young
	 * @param source
	 */
	public static void SelectionSort(int[] source) {
		int index = 0;
		int temp;
		for (int i = 0; i < source.length - 1; i++) {
			index = i;
			for (int j = i + 1; j < source.length; j++) {
				if (source[index] > source[j]) {
					index = j;
				}
			}
			if (i != index) {
				temp = source[i];
				source[i] = source[index];
				source[index] = temp;
			}

		}

		for (int target : source) {
			System.out.println(">>>>" + target);
		}
	}

	public static void InsertionSort(int[] source) {
	}

	public static void QuickSort(int[] source) {

	}
}
