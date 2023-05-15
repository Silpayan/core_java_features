package com.Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class DVDInfo implements Comparable<DVDInfo> {
	String title;
	String genre;
	String leadActor;
	DVDInfo(String t, String g, String a) {
	title = t; genre = g; leadActor = a;
	}
	public String toString() {
		System.out.println("hi from ToString()");
		return title + " " + genre + " " + leadActor + "\n";
	}
	public int compareTo(DVDInfo d) {
		System.out.println("hi from compareTo()");
		return title.compareTo(d.getTitle());
	}
	public String getTitle() {
		System.out.println("hi from getTitle()");
		return title;
	}
	public String getGenre() {
		System.out.println("hi from getGenre()");
		return genre;
	}

	public static void main(String A[]){
		ArrayList<DVDInfo> dvd = new ArrayList<DVDInfo>();
		DVDInfo temp1 = new DVDInfo("AAA", "222", "rdcwd");
		DVDInfo temp2 = new DVDInfo("BBB", "333", "ervd");
		DVDInfo temp3 = new DVDInfo("CCC", "111", "jhrf");
		dvd.add(temp3);
		dvd.add(temp1);
		dvd.add(temp2);
		System.out.println(dvd.toString());
		Collections.sort(dvd);
		System.out.println(dvd.toString());
		GenreSort gs = new GenreSort();
		Collections.sort(dvd, gs);
		System.out.println(dvd);
	}
}
class GenreSort implements Comparator<DVDInfo> {
	public int compare(DVDInfo one, DVDInfo two) {
	return one.getGenre().compareTo(two.getGenre());
	}
}