package com.AccessControlInheritance;

//import org.hamcrest.core.IsInstanceOf;

public class methodCallFromSuper {
	public static void main(String... a){
	
		SubClass sc = new SubClass();
		sc.M1();
	}

}

class SuperClass{
	void M1(){
		System.out.println("Hello from Super.M1");
		System.out.println(this instanceof SubClass);
		M2();
	}
	
	void M2(){
		System.out.println("Hello from Super.M2");
	}
}

class SubClass extends SuperClass{
	void M1(){
		System.out.println("Hello from Sub.M1");
		super.M1();
	}
	
	void M2(){
		System.out.println("Hello from Sub.M2");
	}
}