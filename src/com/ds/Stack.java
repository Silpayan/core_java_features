package com.ds;

public class Stack {

	static Data top;
	static int size = 0;
	public static void main(String s[]){
		try{
			//pop();
			push(1);
			push(2);
			push(3);
			push(4);
			push(5);
			push(6);
			System.out.print("\nStack size = "+size+" Stack : ");
			travers();
			System.out.print("\npoped : "+pop().value);
			System.out.print("\npoped : "+pop().value);
			System.out.print("\npoped : "+pop().value);
			System.out.print("\nStack size = "+size+" Stack : ");
			travers();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	static void push(int value) throws Exception {
		if(top == null){
			top = new Data(value);
			System.out.print("pushed : "+top.value);
		} else if(size < 10){
			Data temp = top;
			top = new Data(value);
			top.next = temp;
			System.out.print("\npushed : "+top.value);
		} else 
			throw new Exception("StackOverFlowException");
		size++;
	}
	
	static Data pop() throws Exception {
		if(top!=null){
			Data temp = top;
			top = top.next;
			temp.next = null;
			return temp;
		} else {
			throw new Exception("StackUnderFlowException");
		}
	}
	
	static void travers(){
		System.out.print("[ ");
		for(Data iterator = top; iterator != null; iterator = iterator.next)
			System.out.print(iterator.value+" ");
		System.out.print("]");
	}
}
