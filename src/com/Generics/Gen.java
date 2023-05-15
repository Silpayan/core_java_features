package com.Generics;

public class Gen<V> {
	V ob;
	
	Gen(V o){
		ob=o;
	}

	V getOb(){
		return ob;
	}
	
	void showType(){
		System.out.println("Type of T is : "+ob.getClass().getName());
	}
}
