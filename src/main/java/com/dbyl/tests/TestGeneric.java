package com.dbyl.tests;

public class TestGeneric {
	public static void main(String[] args) {
		
		Generic<String> gen=new Generic<String>();
		gen.setData("12333");
		System.out.println(gen.getData());
		Generic<Integer> gen1=new Generic<Integer>();
		gen1.setData(1234334);
		System.out.println(gen1.getData());
		

	}

}
