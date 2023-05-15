package com.Serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

class A {//implements Serializable{
	public A() {
        System.out.println("A");
    }
}

class B extends A  implements Serializable{
	public B() {
        System.out.println("B");
        i = "10";
	}
	
	String i;
	Date d;
	
	private void readObject(ObjectInputStream is) throws IOException, ClassNotFoundException { 
		System.out.println("B' readObject()");
		is.defaultReadObject();
		d = (Date)is.readObject();
	}
	
	private void writeObject(ObjectOutputStream os) throws IOException { 
		System.out.println("B's writeObject()");
		os.defaultWriteObject();
		os.writeObject(new Date());
	}
}

public class SrlzSuper {
	
	public static void main(String... args) throws Exception {
		B b = new B();
       
        ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream("datafile"));
        save.writeObject(b); 
        save.flush(); 
        

        ObjectInputStream restore = new ObjectInputStream(new FileInputStream("datafile"));
        B z = (B) restore.readObject();
        System.out.println(z.i+" "+z.d);
        // On the time of deserialization , the Serializable object not 
        // create new object. So constructor of class B does not called.
        // A is not Serializable object so constructor is called.
	}
}