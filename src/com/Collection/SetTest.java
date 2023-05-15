package com.Collection;
import java.util.*;

class SetTest {
	
	int val;
	public SetTest(int a) {
		val = a;
	}
	@Override
	public int hashCode() {
		System.out.println("SetTest's hashCode for "+this.val);
		return 1;
	}
	@Override
	public boolean equals(Object obj) {
		System.out.println("SetTest's equals for "+this.toString());
		return true;
	}
	
	public static void main(String[] args) {
	boolean[] ba = new boolean[6];
	Set s = new HashSet();  // insert code here
	ba[0] = s.add("a");
	ba[1] = s.add(new Integer(42));
	ba[2] = s.add("b");
	ba[3] = s.add("a");
	ba[4] = s.add(new SetTest(1));
	System.out.println("second object");
	ba[5] = s.add(new SetTest(2));
	for(int x=0; x<ba.length; x++)
		System.out.print(ba[x] + " ");
	System.out.println("\n");
	for(Object o : s)
		System.out.print(o + " ");
	}
}