package com;

public class Expressions {

	public static void main(String S[]){
		int a = 11;
		int b = 0;
		int c = 0;
		while(--a>b++)--a;
		System.out.println(a+" "+b);
		
		a=10;b=4;
		for(;a!=b; b++)
			c+=a+b;
		System.out.println(c);
		
		a-=a+=a*1;
		System.out.println(a);
	}
}