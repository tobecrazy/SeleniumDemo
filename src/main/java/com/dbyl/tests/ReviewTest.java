package main.java.com.dbyl.tests;

public class ReviewTest {

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

	public static void main(String[] args) {
		System.out.println("====>" + factorial(6));
		numbersSort();
		System.out.println("====>" + C(6, 4));
	}

	public static String readTXT(String path) {
		return null;
	}

	public static void writeTXT(String path) {

	}
}
