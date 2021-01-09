package com.dbyl.tests;

public class Testssst {

	public static void main(String[] args) {
		int[][] array = new int[][] { { 1, 0, 1, 0 }, { 0, 1, 0, 1 }, { 1, 0, 1, 0 }, { 0, 0, 1, 1 } };
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j]);
			}
			System.out.print("\n");
		}
		int[][] b = flipAndInvertImage(array);
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				System.out.print(b[i][j]);
			}
			System.out.print("\n");
		}
	}

	public static int[][] flipAndInvertImage(int[][] A) {
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j <= A[i].length / 2; j++) {
				int temp = A[i][j];
				A[i][j] = A[i][A[i].length - 1 - j];
				A[i][A[i].length - 1 - j] = temp;

				if (A[i][j] == 1) {
					A[i][j] = 0;
				} else {
					A[i][j] = 1;
				}

				if (A[i][A[i].length - 1 - j] == 1) {
					A[i][A[i].length - 1 - j] = 0;
				} else {
					A[i][A[i].length - 1 - j] = 1;
				}
			}
		}
		return A;
	}

}
