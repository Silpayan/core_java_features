package com.ds;

public class SortedArray2BBST {

	static int a[]={1,2,3,4,5,6,7,8,9};
	public static void main(String s[]){
		Tree root = constructTree(0,a.length);
		System.out.println("Tree");
		TreeTraversal.inOrderTraversal(root);
	}
	static Tree constructTree(int start, int length) {
		if(length > 0){
			Tree root = new Tree(a[start+length/2]);
			root.leftChild = constructTree(start, length/2);
			if(length%2 == 1)
				root.rightChild = constructTree(start+length/2+1, length/2);
			else
				root.rightChild = constructTree(start+length/2+1, length/2-1);
			return root;
		}
		
		return null;
	}
}
