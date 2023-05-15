package com.ControllFlow;

enum Color {red, green, blue}

public class ConditionStatements {

	public static void main(String s[]){
		SCJP exam = new SCJP(); 
		if (exam.done())
			if (exam.getScore() < 0.61)
			System.out.println("Try again.");
			// Which if does this belong to?
			else System.out.println("Java master!");//belongs to preceding if
		int i = 10;
		boolean t;
		if(i < 20)
			System.out.println(" i < 20");
		else if(i == 10)
			System.out.println(" i == 10");
		if(t = true) //if(i = 10) then error as i int
			System.out.println(" i = 10");
		final int a = 1;
		final int b;
		b = 2;
		int x = 0;
		switch (x) {
		case a: // ok
		//case b: // compiler error
		}
		
		/*switch(x) {
		case b {
		y = 7;
		}
		}*/
		
		/*switch(x) {
		0: { }
		1: { }
		}*/
		
		Color c = Color.green;
		switch(c) {
		case red: System.out.print("red ");
		case green: System.out.print("green ");
		case blue: System.out.print("blue ");
		default: System.out.println("done");
		}
	}
}

class SCJP{
	boolean done(){
		return true;
	}
	double getScore(){
		return 0.7;
	}
}