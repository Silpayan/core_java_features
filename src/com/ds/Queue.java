package com.ds;

public class Queue {

	static Data font = null;
	static Data rear ;
	static int size = 0;
		
	static void offer(int value) throws Exception{
		if(rear == null){
			font=rear = new Data(value);
			size++;
			System.out.println("pushed : "+font.value);
		} else if(size < 10 ){
			rear.next = new Data(value);
			rear = rear.next;
			System.out.println("pushed : "+rear.value);
			size++;
		} else {
			throw new Exception("QueueOverFlowException");
		}
	}
	
	static void poll() throws Exception{
		if(font != null){
			System.out.print("\npopped : "+font.value);
			Data temp = font.next;
			font.next = null;
			font=temp;
			size--;
		} else 
		throw new Exception("QueueUnderFlowException");
	}
	
	static void travers(){
		System.out.print("[ ");
		for(Data iterator = font; iterator != null; iterator = iterator.next)
			System.out.print(iterator.value+" ");
		System.out.print("]");
	}
	
	public static void main(String s[]){
		try{
			offer(1);
			offer(2);
			offer(3);
			offer(4);
			offer(5);
			offer(6);
			offer(7);
			offer(8);
			offer(9);
			offer(10);
			System.out.print("Queue size = "+size+" Queue : ");
			travers();
			poll();
			poll();
			System.out.print("\nQueue size = "+size+" Queue : ");
			travers();
			poll();
			poll();
			poll();
			poll();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}

class Data{
	int value;
	Data next;
	
	Data(int value){
		this.value = value;
		next = null;
	}
}