package com.AccessControlInheritance;

public class Overloading {

	public static void main(String... s){
		Overloading o = add(1);
		System.out.println(o);
		System.out.println(o.add(1,2));
		System.out.println(o.add(1222222222,"silpo"));
		System.out.println(o.add("ritu", 923793223));
		System.out.println(o.add(null));
	}
	
	static Overloading add(int a){
		System.out.print("add(int) returns ");
		return new Overloading();
	}
	
	Overloading add(Object a){
		System.out.print("add(Object) returns ");
		return new Overloading();
	}
	
	int add(int a, int b){
		System.out.print("add(int a, int b) returns ");
		return a+b;
	}
	
	long add(long l, String s){
		System.out.print("add(long l, String s) returns ");
		return 1;
	}
	
	String  add(String s, long l){
		System.out.print("add(String s, long l) returns ");
		return "s";
	}
}