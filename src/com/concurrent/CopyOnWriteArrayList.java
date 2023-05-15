package com.concurrent;

import java.util.ListIterator;

public class CopyOnWriteArrayList {
	public static void main(String s[]){
		java.util.concurrent.CopyOnWriteArrayList<String> copyAL = new java.util.concurrent.CopyOnWriteArrayList();
		copyAL.add("Silpayan");
		copyAL.add("silpayan");
		copyAL.add("Silpayan");
		copyAL.addIfAbsent("Silpayan");
		System.out.println(copyAL);
		
		for(String name : copyAL){
			System.out.println(name);
		}
		
		ListIterator<String> names = copyAL.listIterator();
		while(names.hasNext()){
			if(names.next().equals("silpayan")){
				System.out.println(copyAL.indexOf("silpayan"));
				names.remove();break;
			}
		}
		
		System.out.println(copyAL);
	}
}
