package com.Collection;
import java.util.*;

public class TestArraySort {
		public static void main(String[] args) {
		ArrayList<String> stuff = new ArrayList<String>(); // #1
		System.out.println(stuff.size());
		stuff.add("Denver");
		stuff.add("Boulder");
		stuff.add("Vail");
		stuff.add("Aspen");
		stuff.add("Telluride");
		System.out.println("unsorted " + stuff);
		Collections.sort(stuff); // if it is some other object list then it needs to implements comparable
		System.out.println("sorted " + stuff);
		}

}
