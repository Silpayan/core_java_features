package com.Generics;

public class SimpGen {

	public static void main(String[] args) {

		GenTwo<Integer, String> gtObj = new GenTwo<Integer, String>(88,"Generics");
		gtObj.showType();
		
		int v = gtObj.getOb1();
		System.out.println("value : "+v);
		
		String Str = gtObj.getOb2();
		System.out.println("value : "+Str);
	}

}
