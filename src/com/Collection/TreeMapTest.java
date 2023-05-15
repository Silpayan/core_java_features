package com.Collection;

import java.lang.Comparable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
public class TreeMapTest {
	public static void main(String a[]){
		
		Map m = new TreeMap<Student, String >();
		Map n = new HashMap<Student, String >();
		StudentComparator sC = new StudentComparator();
		Map mCmptor = new TreeMap(sC);
		
		Student s1 = new Student(1, "s1");
		Student s2 = new Student(2, "s2");
		Student s3 = new Student(3, "s3");
		
		m.put(s3, "arg3");n.put(s3, "arg3");mCmptor.put(s3, "arg3");
		m.put(s1, "arg1");n.put(s1, "arg1");mCmptor.put(s1, "arg1");
		m.put(s2, "arg2");n.put(s2, "arg2");mCmptor.put(s2, "arg2");
		
		System.out.println(" m: "+m+"\n n: "+n+"\nmC: "+mCmptor);
	}
}

class Student implements Comparable<Student>{
	int id;
	String Name;
	Student(int id, String Name){
		this.id = id;
		this.Name = Name;
	}
	
	
	@Override
	public int hashCode() {
		System.out.println("Hello from Student's Hashcode");
		return id;
	}
	
	@Override
	public boolean equals(Object obj) {
		System.out.println("Hello from Student's equal");
		return this.Name.equalsIgnoreCase(((Student)obj).Name);
	}
	
	//@Override
	public int compareTo(Student s) {
		System.out.println("From CompareTo of Student");
		//return Name.compareTo(s.Name);
		if(this.id == s.id)
			return 0;
		else if(this.id > s.id)
			return 1;
		else return -1;
	}
	
	@Override
	public String toString() {
		return this.id+" "+this.Name+" ";
	}
	
}

class StudentComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		System.out.println("From StudentComparator's compare");
		//return o2.compareTo(o1); //Calling Student's Comparator
		if(o1.id == o2.id)
			return 0;
		else if(o2.id > o1.id)
			return 1;
		else return -1;
	}
	
}