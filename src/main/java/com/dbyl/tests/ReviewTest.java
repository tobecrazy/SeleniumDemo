package com.dbyl.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;

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

		// StringBuffer sb = new StringBuffer();
		// sb.append("11111");
		// StringBuilder sbu = new StringBuilder();
		// sbu.append("22222");
		// String str = new String("433333");
		//
		// Map map = new Map();
		// Set set = new Set();
		// set.add("111112");
		// set.add("111112");
		//
		// int[] array = new int[] { 1, 3, 4, 2, 1, 0, 5 };
		// removeDuplicatedValue(array);
		// Object[] object = new Object[] { 1, 3, 4, 2, 1, 0, 5 };
		// removeDuplicatedValue(object);
		// InsertionSort(array);
		// Thread thread1 = new Thread(new Runnable() {
		//
		// @Override
		// public void run() {
		// SelectionSort(array);
		//
		// }
		// });
		// thread1.start();
		// MyThread thread2 = new MyThread(MyThread.class.getName());
		// thread2.start();
		// try {
		// Thread.sleep(1000);
		// } catch (InterruptedException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		// try {
		// thread2.isRun = false;
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		// MyComputer pc = new MyComputer();
		// Screen a = new Screen() {
		//
		// @Override
		// public void display(int height, int weight) {
		// System.out.println("I'm a interface with two paramters");
		//
		// }
		// };
		// pc.setOnScreen(a);
		// a.display(1, 2);
		// pc.dowork();
		// pc.dowork("Printing");

		// BubbleSort(array);

		// System.out.println("====>" + factorial(6));
		// numbersSort();
		// System.out.println("====>" + C(6, 4));
		// String text = readTXT("/Volumes/Transcend/xiazai/love.txt");
		// System.out.println("====>" + text);
		// writeTXT("/Volumes/Transcend/xiazai/lesson1.txt", text);

		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.add("11111");
		linkedList.add("1233");
		linkedList.add("1222");
		linkedList.add("last");
		linkedList.add(0, "first");
		linkedList.addLast("last");
		linkedList.removeLast();
		Iterator<String> iterator = linkedList.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		ArrayList<String> arrayList = new ArrayList<String>();

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
		int temp;

		for (int i = 0; i < source.length; i++) {
			int j = i;
			while (j > 0) {
				if (source[j] < source[j - 1]) {
					temp = source[j];
					source[j] = source[j - 1];
					source[j - 1] = temp;
				} else {
					break;
				}

				j--;
			}

		}

		for (int target : source) {
			System.out.println(">>>>" + target);
		}
	}

	public static void QuickSort(int[] source) {

	}

	/**
	 * @author young
	 * @param source
	 * @return
	 */
	public static ArrayList<Object> removeDuplicatedObject(Object[] source) {
		int length = source.length;

		ArrayList<Object> list = new ArrayList<Object>();
		for (int i = 0; i < length; i++) {
			Object temp = source[i];
			if (!list.contains(temp)) {
				list.add(temp);
			}
		}
		for (Object i : list) {
			System.out.println("xxx" + i);
		}
		return list;
	}

	/**
	 * This method will remove duplicate value
	 * 
	 * @author young
	 * @param source
	 */
	public static LinkedHashSet<Object> removeDuplicatedValue(Object[] source) {

		LinkedHashSet<Object> set = new LinkedHashSet<Object>();
		for (Object obj : source) {
			set.add(obj);
		}

		source = set.toArray();
		for (Object temp : source) {
			System.out.println("=====>" + temp.toString());
		}
		return set;
	}
	
	
	public static LinkedHashSet<Object> removeDuplicatedRaw(Object[] source) {

		LinkedHashSet<Object> set = new LinkedHashSet<Object>();
		for (Object obj : source) {
			set.add(obj);
		}

		source = set.toArray();
		for (Object temp : source) {
			System.out.println("=====>" + temp.toString());
		}
		return set;
	}
	
	
	

			

}
