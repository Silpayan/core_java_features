package com.ControllFlow.Excptn;


public class CheckedExceptionTest {

	public static void main(String s[]){
		
		throwException();
	}

	public static void throwException() {
		try{
			throw new CheckedException("This is Checked Exception");
		}catch (CheckedException ce){
			ce.printStackTrace();
		}finally{
			System.out.println("Kaka chalie jao");
		}	
	}
}

class CheckedException extends Exception  {
	static String s;
	CheckedException(String s){
		super(s);
	}
}
