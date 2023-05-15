package com.Serialization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjSer {
	SuperObj so = new SuperObj();
	int check = 1;
	
	public static void main(String s[]){
		ObjSer os = new ObjSer();
		try {
            FileOutputStream fos = new FileOutputStream("serlz.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(os);
            oos.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
	}
}


//class SuperObj implements Serializable{}
class SuperObj implements Serializable {
	
}