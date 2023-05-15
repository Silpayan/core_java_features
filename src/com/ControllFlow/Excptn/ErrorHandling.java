package com.ControllFlow.Excptn;

public class ErrorHandling {

	public static void main(String... args) {
		try{
			System.out.println("main() Error");
			main("silpo");
		} catch (StackOverflowError e) {
			System.out.println("Error occured, catched");
			e.printStackTrace();
			return;
		} finally{
			System.out.println("Error occured");
		}
	}
}
