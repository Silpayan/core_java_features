package com.designpattern;

class SingleTone {
	static SingleTone singleTone = new SingleTone();
	private SingleTone(){
		System.out.println("Initialializing SingleTone");
	}
	
	public static synchronized SingleTone getSingleTone(){
				
		//System.out.println("it is not possible to get a SingleTone Object");
		return singleTone;
	}
	
	protected void finalize() throws Throwable{
		
		System.out.println("From finalize");
	}
}

/*class SubSingleTone extends SingleTone{
	public SubSingleTone() {
		super();
		
	}
}*/

public class UseSingle extends Thread{
	public static void main(String a[]) throws InterruptedException{
		UseSingle us = new UseSingle();
		Thread t = new Thread(us);
		t.setName("t");
		Thread t1 = new Thread(us);
		t1.setName("t1");
		Thread t2 = new Thread(us);
		t2.setName("t2");
		Thread t3 = new Thread(us);
		t3.setName("t3");
		t.start();
		t1.start();
		t2.start();
		t3.start();
	}
	
	public void run(){
		SingleTone st = SingleTone.getSingleTone();
		
		if(st != null){
			System.out.println(this.getName()+" Using SingleTone "+st.toString());
			st = null;
			System.gc();
		} else {
			//Wait for SingleTone to be available
			for(int i= 0;i<100;i++);
		}
	}
}