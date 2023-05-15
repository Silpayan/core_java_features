package com.Initialization;

public class StaticBlock {
	static String i = "";
	static{
		i="Static block";
		System.out.println(i);
	}
	
	{
		i="Instance block";
		System.out.println(i);
	}
	public static void main(String []ss)
	{
		System.out.println("First Statement from main()");
		StaticBlock sb = new StaticBlock();
	}
}
