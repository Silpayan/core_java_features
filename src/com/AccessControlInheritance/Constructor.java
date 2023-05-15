package com.AccessControlInheritance;

class SomeThing{
	
}

public class Constructor extends SomeThing{
	int a,b,ab;
	
	public Constructor() {
		ab = 23;
	}
	
	Constructor(int x, int y){
		a = x;
		b = y;
	}

	public static void main(String str[]) {

		Constructor c = new Constructor();
		Constructor c1 = new Constructor(2,3);
		
		System.out.println(c.a+" "+c.b+" "+c.ab);
		System.out.println(c1.a+" "+c1.b+" "+c1.ab);
		
		try{
			int a = Integer.parseInt("3");
		} catch(NumberFormatException nfe)
		{
			System.out.println(nfe);
		}
	}
}