package com.Collection;

import java.util.Set;

public class LinkedHashSet {

	public static void main(String... a) {
		Set<String> lhs = new java.util.LinkedHashSet<String>();
		lhs.add("1");
		lhs.add("5");
		lhs.add("1");
		lhs.add("3");
		lhs.add("4");
		lhs.add("2");
		System.out.println(lhs);
	}

}
