
public class operations {
	public static void main(String []as){
		int integer = 129;
		byte bytevalue = (byte)integer;
		double f = 1.2767665;
		System.out.println("integer = "+integer+"\t bytevalue = "+bytevalue);
		bytevalue = (byte)f;
		System.out.println("float = "+f+"\t bytevalue = "+bytevalue);
		f++;
		System.out.println("float = "+f);
		System.out.println("We put two and two together and get " + (2 + 2));
		char c = '2';
		System.out.println("We put two and two together and get " + 2 + c);
		
		String theName = " Uranium";
		theName = " Pure" + theName;                  // " Pure Uranium"
		String trademark1 = 100 + "%" + theName;      // "100% Pure Uranium"
		System.out.println(trademark1);
		String trademark2 = 100 + '%' + theName;
		System.out.println(trademark1);
        int k = 1;
        int i = ++k + k++ + + k;
        System.out.println(i);
	}
}