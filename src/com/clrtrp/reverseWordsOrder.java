package com.clrtrp;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

public class reverseWordsOrder {
	public static void main(String s[]){
//		String st = " ";
//		String sb = reversString(st);
//		System.out.println("start"+sb.toString()+"end");
		Vector a = new Vector<String>();
		a.add("A");
		a.add("AB");
		a.add("ACD");
		a.add("A");
		a.add("ABCD");
		a.add("JHRIUJWGAMGDNFXSHBP");
		a.add("PRDJNRZVNMXRE");
		removeDuplicate(a);
	}

	public static String reversString(String a) {
		
		String s[] = a.split(" ");
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i<s.length; i++){
			sb.append(s[s.length-i-1]);
			if(i!= s.length-1)sb.append(" ");
		}
		return sb.toString();
	}

	static void removeDuplicate(Vector <String>a) {
		Set s = new HashSet();
		
		int count = 0;
		while(a.size()> count){
			if(!s.add(a.get(count)))
				a.removeElementAt(count);
			count++;
		}
		Iterator i = a.iterator();
		count = 0;
		while(i.hasNext()){
			System.out.println(i.next());
		}
		
		

	}
}
