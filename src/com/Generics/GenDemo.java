package com.Generics;

public class GenDemo {

	
	public static void main(String[] args) {
		Gen<Integer> iob = new Gen<Integer>(88);
		//dob = new Gen<Double>(88.0);
		iob.showType();
		
		int v = iob.getOb();
		System.out.println("value = "+v);
		
		Gen<String> sob;
		sob = new Gen<String>("Generics Test");
		sob.showType();
		
		String str = sob.getOb();
		System.out.println("value = "+str);
		
	}

}
