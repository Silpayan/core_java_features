package Bit;

public class Shift {
	public static void main(String[] arg) {
		int a = 7;
	    int b = 2;
	    int c = 3;

	    a |= 4;
	    c <<= 1;
	    b >>=1;
	    //a ^= c;
	    System.out.println("a = " + a); //111 | 100 => 111
	    System.out.println("b = " + b); //11 <<= 1 => 111/110?
	    System.out.println("c = " + c); //10 >>= 1 => 1
	    
	  }
}
