package com.Thread;

import com.ds.LinkedList;

public class WaitNotify extends Thread{
	
	static WaitNotify o = new WaitNotify();
	String s = "String";
	public static void main(String s[]){
		Thread t1 = new Thread(new WaitNotify());
		Thread t2 = new Thread(new WaitNotify());
		Thread t3 = new Thread(new WaitNotify());
		t1.start();
		t2.start();
		t3.start();
	}
	
	public void run(){
			o.doJob();
	}
	
	public void doJob(){
		synchronized (o) { //synchronized(s)
			try{
				wait(100);
			}catch(InterruptedException ie){
				ie.printStackTrace();
			}
			o.notify();
			System.out.println(o.getPriority());
		}
	}
}
