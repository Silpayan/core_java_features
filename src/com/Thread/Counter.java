package com.Thread;

public class Counter {

	Integer a= new Integer(0);
	Integer b= new Integer(0);
	
	int aIncr(){
		synchronized (a) {
			return a++;
		}
	}
}
