package com.dbyl.tests.training.day1;

import com.dbyl.tests.training.day3.Rect;

public class NXN {

	public static void main(String[] args) {
		for(int x=1;x<=100;x++)
		{
			System.out.print(x);
			if(x>2)
			{
				break;
			}
		}
		int[] array = { 1, 2, 3, 4 };
		int t = 0;
		switch (t) {
		case 1:
			System.out.println(array[0]);
			break;
		case 2:
			System.out.println(array[1]);
			break;
		case 3:
			System.out.println(array[2]);
			break;
		case 4:
			System.out.println(array[3]);
			break;
		default:
			System.out.println("Nat Match");
		}

		 for (int i = 1; i <= 9; i++) {
		 for (int j = 1; j <= i; j++) {
		 System.out.print(j + "X" + i + "=" + i * j + " ");
		 }
		 System.out.println();
		 }
		 int a=103,b=51;
		// b=a+b;
		// a=b-a;
		// b=b-a;
		 b=a^b;
		 a=b^a;
		 b=b^a;
		 System.out.println(a+"\t"+b);
		Rect aRect = new Rect(1, 2);
		Rect bRect = new Rect(3, 5);

		System.out.println(aRect.x + " " + aRect.add());

	}

}
