package com.AccessControlInheritance;

class C {

}

class D extends C{

}
interface AB{Object getOBJ(); void Stat();
void Test();}
class A implements AB{
	
	public C getOBJ(){
		System.out.println("class A - return C");
		return new C();
		
	}
	
	public void Test(){
		System.out.println("Class A - Test");
	}
	
	void A1(){}
}

class B extends A{
	//@Override
	public D getOBJ(){
		System.out.println("class B - return D");
		return new D();
		
	}
	
	protected void A1(){}
	@Deprecated
	public String deprecatedM(){
		return "Deprecatated";
	}

}

public class Overridding {

@SuppressWarnings("deprecation")
public static void main(String... args) {
    
		AB ab = new A(); 
		A a = new A();
		B b = new B();
    
		ab.getOBJ();
		a.getOBJ();
		((AB)b).getOBJ();//Class B's method is called
		((AB)b).Test();//Class A who implts AB method is called, 
					//as B doesn't have the same method
    
		System.out.println(b.deprecatedM());
		
		S1 S1 = new S1();
        S2 S2= new S2();
        System.out.println("Print S1 " + S1.gets()); 
        System.out.println("Print S1 " + S2.gets());
        S1=S2;
        System.out.println("Print S1 now " + S1.gets()) ;
        System.out.println( "Print S1.gets() now " + S2.gets());
    
	}
}	

class S1{  
    private String S= "S1";
    public String gets() {
        return S;
    }
}
class S2 extends S1 {
    private String S = "S2";
    public String gets() {
        return S;
    }
}
