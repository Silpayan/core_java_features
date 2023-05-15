package com.AccessControlInheritance;

public class Inheritance {
	public static void main(String[]args)throws Exception {
		AClass a = new AClass();
		BClass b = new BClass();
		a = b;
		BClass c = ((BClass)a);
		
		a.displayClassName(); // A
		
		b.displayClassName(); // B
		c.displayClassName(); // B not A
		
	}
}


class AClass{
	String className = "A";
	static transient int i;
	
	AClass()throws Exception{
		i = 10;
		//throw new Exception();
	}
	
	static {
		//i = 0;
		System.out.println(i);
		
	}
	
	public void displayClassName() throws ClassNotFoundException {
		System.out.println(className);
		//return classsName;
	}
}

class BClass extends AClass{
	String className = "B";
	
	static void test(){
		
	}
	
	public void displayClassName() throws ClassCastException{
		System.out.println(className);	
	}
}