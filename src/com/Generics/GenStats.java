package com.Generics;

public class GenStats<T extends Number> {

	T[] nums;
	
	GenStats(T[] o){
		nums = o;
	}
	
	double average(){
		double sum = 0.0;
		
		for(int i = 0; i < nums.length; i++)
			sum+=nums[i].doubleValue();
			
		return sum/nums.length;
	}

	boolean sameAvg(GenStats<? super Integer> o){//boolean sameAvg(GenStats<? extends Double> o)
		
		if(average() == o.average())
			return true;
		return false;
	}
	
	public static void main(String[] args) {

		Integer inums[] = {1,2,3,4,5};
		GenStats<Integer> iob = new GenStats<Integer>(inums);
		double v = iob.average();
		System.out.println("iob average : "+v);
		
		Double dnums[] = {1.0,2.0,3.0,4.0,5.3};
		GenStats<Double> dob = new GenStats<Double>(dnums);//GenStats dob = new GenStats(dnums); T = Object
		double w = dob.average();
		System.out.println("dob average : "+w);
		
		System.out.print("Average of iob and dob is ");
		if(iob.sameAvg(dob))
			System.out.println("same");
		else
			System.out.println("different");
		
		System.out.print("Average of dob and iob is ");
		if(dob.sameAvg(iob))
			System.out.println("same");
		else
			System.out.println("different");
	}
}