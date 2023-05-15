package com.annotationReflection;

class C {

}

class D extends C{

}

class A {
	
	public C getOBJ(){
		System.out.println("class A - return C");
		return new C();
		
	}

}

class B extends A{
	//@Override
	public D getOBJ(int i){
		System.out.println("class B - return D");
		return new D();
		
	}
	@Deprecated
	public String deprecatedM(){
		return "Deprecatated";
	}

}

public class Overridding {

@SuppressWarnings("deprecation")
public static void main(String... args) {
     A a = new B();
     B b = new B();
     a.getOBJ();
     //b.getOBJ(9);
	 System.out.println(b.deprecatedM());
     }
}