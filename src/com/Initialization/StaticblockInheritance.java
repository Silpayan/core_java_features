package com.Initialization;

class SuperClass {
	static{
		System.out.println("Hello from superclass static block");
	}
	SuperClass(){
		System.out.println("Hello from superclass constractor");
	}
}

class SubClass extends SuperClass {
	static{
		System.out.println("Hello from subclass static block");
	}
	SubClass() throws Exception{
		this("from subclass");
		System.out.println("Hello from subclass constractor");
	}
	
	SubClass(String s){
		System.out.println("Hello "+s+"Parameterized Constractor");
	}
}

class StaticblockInheritance{
	public static void main(String a[])throws Exception {
		Class c   = Class.forName("com.Initialization.SuperClass"); 
		//SuperClass sc = new SubClass();
	}
}