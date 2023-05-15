package com.Thread;

public class MethodSync extends Thread {

	public static void main(String s[]){
		final MethodSync ms = new MethodSync();
		Thread t1 = new Thread(ms){
			public void run(){
				ms.regMethod();
			}
		};
		Thread t2 = new Thread(ms){
			public void run(){
				ms.syncInsMethod();
			}
		};
		Thread t3 = new Thread(ms){
			public void run(){
				MethodSync.staticMethod();
			}
		};
		Thread t4 = new Thread(ms){
			public void run(){
				MethodSync.syncStaticMethod();
			}
		};
		Thread t5 = new Thread(ms){
			public void run(){
				ms.regMethod1();
			}
		};
		Thread t6 = new Thread(ms){
			public void run(){
				ms.syncInsMethod1();
			}
		};
		Thread t7 = new Thread(ms){
			public void run(){
				MethodSync.staticMethod1();
			}
		};
		Thread t8 = new Thread(ms){
			public void run(){
				MethodSync.syncStaticMethod1();
			}
		};
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		/*t5.start();
		t6.start();
		t7.start();
		t8.start();*/
		
	}
	
	static void staticMethod(){
		System.out.println("Hello from staticMethod()starts");
		try{
			Thread.sleep(1000);
		} catch(InterruptedException ie){
			ie.printStackTrace();
		}
		System.out.println("Hello from staticMethod()ends");
	}
	
	static synchronized void syncStaticMethod(){
		System.out.println("Hello from syncStaticMethod() starts");
		try{
			Thread.sleep(1000);
		} catch(InterruptedException ie){
			ie.printStackTrace();
		}
		System.out.println("Hello from syncStaticMethod() ends");
	}
	
	synchronized void syncInsMethod(){
		System.out.println("Hello from syncInsMethod() starts");
		try{
			Thread.sleep(1000);
		} catch(InterruptedException ie){
			ie.printStackTrace();
		}
		System.out.println("Hello from syncInsMethod() ends");
	}

	void regMethod(){
		System.out.println("Hello from regMethod() starts");
		try{
			Thread.sleep(1000);
		} catch(InterruptedException ie){
			ie.printStackTrace();
		}
		System.out.println("Hello from regMethod() ends");
	}

	static void staticMethod1(){
		System.out.println("Hello from staticMethod1()starts");
		try{
			Thread.sleep(1000);
		} catch(InterruptedException ie){
			ie.printStackTrace();
		}
		System.out.println("Hello from staticMethod1()ends");
	}
	
	static synchronized void syncStaticMethod1(){
		System.out.println("Hello from syncStaticMethod1() starts");
		try{
			Thread.sleep(1000);
		} catch(InterruptedException ie){
			ie.printStackTrace();
		}
		System.out.println("Hello from syncStaticMethod1() ends");
	}
	
	synchronized void syncInsMethod1(){
		System.out.println("Hello from syncInsMethod1() starts");
		try{
			Thread.sleep(1000);
		} catch(InterruptedException ie){
			ie.printStackTrace();
		}
		System.out.println("Hello from syncInsMethod1() ends");
	}

	void regMethod1(){
		System.out.println("Hello from regMethod1() starts");
		try{
			Thread.sleep(1000);
		} catch(InterruptedException ie){
			ie.printStackTrace();
		}
		System.out.println("Hello from regMethod1() ends");
	}
}