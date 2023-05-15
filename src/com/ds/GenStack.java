package com.ds;

public class GenStack<Gen> {

	private Gen Top;
	Gen obj;
	
	public GenStack() {
		// TODO Auto-generated constructor stub
	}
	
	void push(Gen obj){
		this.obj = obj;
	}
}
