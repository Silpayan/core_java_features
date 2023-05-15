package com.Serialization;

import java.io.*;
import java.util.*;



class ExtrnlzTest implements Externalizable {
      int i;
      String s;
      
      public ExtrnlzTest() {
            System.out.println("Data default constructor");
      }
      
      public ExtrnlzTest(String x, int a) {
            System.out.println("Second constructor");
            s = x; i = a;
      }
      
      public String toString() {
            return s + i;
      }
      
      public void writeExternal(ObjectOutput out) 
            throws IOException {
            out.writeObject(s);
            out.writeInt(i);
      }
      
      public void readExternal(ObjectInput in) {
    	  try{
            s = (String)in.readObject();
            i = in.readInt();
    	  }catch(IOException ioe){
    		  ioe.printStackTrace();
    	  }catch(ClassNotFoundException cnfe){
    		  cnfe.printStackTrace();
    	  }
      }
      
      public static void main(String[] args) 
              throws IOException, ClassNotFoundException {
    	  	ExtrnlzTest d = new ExtrnlzTest("String value",1514);
            System.out.println(d);
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("input\\data"));
            o.writeObject(d);
            o.close();

            // Now deserialize
            ObjectInputStream in = new ObjectInputStream(
                  new FileInputStream("input\\data"));
            d = (ExtrnlzTest)in.readObject();
      }
}