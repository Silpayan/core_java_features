package com.ds;

public class ShiftK {
	public static void main(String... s){
		System.out.println("JIO");
		int A[] = { 1, 2, 3, 4, 5};
		int k=3;
		int B[] = new int[3];
		
		System.out.print("A : ");
		for(int i:A)
		System.out.print(A[i-1]);
		
		for (int i=0;i<A.length;i++){
			if(i<k) {
				A[i] = A[(i+k)%A.length] ;
				B[i] = A[i];
			}else {
				A[i] = B[i-k];
			}
		}
		
		System.out.print("\nA : ");
		for(int i:A)
		System.out.print(A[i-1]);
		
	}
}
