package com.AccessControlInheritance;

import java.net.InterfaceAddress;

interface Intrfce1{
	int i = 0;
	void method();
}

interface Intrfce2{
	int i = 10;
	void method();
}

public class MultipleInhrtnce implements Intrfce1, Intrfce2{

	public void method(int i){		
	}
	public static void main(String... a){
		MultipleInhrtnce m = new MultipleInhrtnce();
		m.method();
		Class1 c1 = new Class1();
		c1.method();
		c1 = new Class2();
		c1.method();
	}
	public void method(){
		System.out.println("method from MultipleInhrtnce"+Intrfce1.i);
	}
}

class Class1 implements Intrfce1{

	@Override
	public void method() {
		System.out.println("method from Class1");
		
	}
}
	
class Class2 extends Class1 implements Intrfce2{

	@Override
	public void method() {
		System.out.println("method from Class2");	
	}	
}