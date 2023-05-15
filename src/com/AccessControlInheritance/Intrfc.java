package com.AccessControlInheritance;

interface IInterface{
		void method();
	}

public class Intrfc implements IInterface{
	
	public static void main(String s[]){
		Intrfc1 i1 = new Intrfc1();
		i1.method();
		System.out.println("Main");
	}

	@Override
	public void method() {
		// TODO Auto-generated method stub
	}
}

class Intrfc1 extends absIntrfc implements IInterface{

	@Override
	public void method() {
		// TODO Auto-generated method stub
	}
	
	public void a(int i){
		
	}
	
	public IInterface a(String s) throws Exception{
		return new Intrfc();
	}

	@Override
	public int absMethod() {
		// TODO Auto-generated method stub
		return 0;
	}
}
abstract class absIntrfc{
	public abstract int absMethod();
	public absIntrfc() {
		System.out.println("abstruct class constructor!");
	}
}