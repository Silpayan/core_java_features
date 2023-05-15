package com.Generics;

public class GenTwo<X,Y> {


	X ob1;
	Y ob2;
	
	GenTwo(X o1, Y o2){
		ob1=o1;
		ob2 = o2;
	}

	X getOb1(){
		return ob1;
	}
	Y getOb2(){
		return ob2;
	}
	
	void showType(){
		System.out.println("Type of X is : "+ob1.getClass().getName());
		System.out.println("Type of Y is : "+ob2.getClass().getName());
	}
}
