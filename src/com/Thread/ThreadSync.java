package com.Thread;

public class ThreadSync implements Runnable{

	public static void main(String a[]){
		Runnable r = new ThreadSync();
		Thread t = new Thread(r);
		Thread t1 = new Thread(r);
		t.setName("t");
		t1.setName("t1");
		//System.out.println(Runtime.totalMemory()-Runtime.freeMemory() );
		t.start();
		t1.start();
	}
	
	public void run(){
		ThreadSync ts = new ThreadSync();
		try{
			synchronized (ts) {
				System.out.println("Waiting For notification on This");
				
				//ts.wait(10);//java.lang.IllegalMonitorStateException
				
				wait(); // Hangs as needed notification on this.
				//ts.notifyAll();
				System.out.println("Got Notification on This");
			}
		}catch(InterruptedException ie){
			ie.printStackTrace();
		}
	}
}
