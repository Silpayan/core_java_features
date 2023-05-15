package com.ds;

public class TreeTraversal {

	public static void main(String... a){
		Tree root = treeCons(1);
		System.out.print("inOreder : ");
		inOrderTraversal(root);
		System.out.print("\npreOrder : ");
		preOrderTraversal(root);
		System.out.print("\npostOrder : ");
		postOrderTraversal(root);
	}

	static void inOrderTraversal(Tree root){
		if(root.leftChild != null)
			inOrderTraversal(root.leftChild);
		System.out.print(root.data+" ");
		if(root.rightChild != null)
			inOrderTraversal(root.rightChild);
	}
	static void preOrderTraversal(Tree root){
		System.out.print(root.data+" ");
		if(root.leftChild != null)
			preOrderTraversal(root.leftChild);
		if(root.rightChild != null)
			preOrderTraversal(root.rightChild);
	}
	
	static void postOrderTraversal(Tree root){
		if(root.leftChild != null)
			postOrderTraversal(root.leftChild);
		if(root.rightChild != null)
			postOrderTraversal(root.rightChild);
		System.out.print(root.data+" ");
	}

	static Tree treeCons(int i){
		
		Tree root = null;
		if( i<=7 ){
			root = new Tree(i);
			root.leftChild = treeCons(2*i);
			root.rightChild = treeCons(2*i+1);
		}
		return root;
	}
}

class Tree{
	Tree leftChild;
	Tree rightChild;
	int data;

	Tree(int s){
		data = s;
	}
	
	protected void travers() {
		if(this != null){
			System.out.print(" "+this.data);
			this.leftChild.travers();
			this.rightChild.travers();
		}
	}
}