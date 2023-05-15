package com.Thread;

class A implements Runnable{
	public void run(){
		System.out.println(Thread.currentThread().getName());
	}   
}


public class BasicThrd {		
	public static void main(String... args) {	
		A a = new A();
		Thread t = new Thread(a);
		Thread t1 = new Thread(a);		
		t.setName("t");
		t1.setName("t1");
		t.setPriority(10);
		t1.setPriority(1);
		t.start();
		t1.start();
		
	}
}
