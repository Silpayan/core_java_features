package com.ds;

public class Factorial {

	private long fact1(long num){
		long factorialValue = 1;
		//System.out.println("Now Number"+num);
		if( num>0 )
			factorialValue = num*fact(num-1); 
		return factorialValue;
	}
	
	private long fact(long num){
		long factorialValue = 1;
		System.out.println("Calculating ! of " + num );
		while(num>1){
			factorialValue = factorialValue * num;
			num--;
		}
		return factorialValue;
	}
	
	public static void main(String S[]){
		long value = 10;
		Factorial f = new Factorial();
		System.out.println("!"+value+"="+f.fact(value));
	}
}