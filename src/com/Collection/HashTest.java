package com.Collection;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.HashSet;

public class HashTest {
    
    private String str;
    
    public HashTest(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
    	System.out.println("from HashTest toString");
        return str;
    }
    
    @Override
    public int hashCode() {             
    	System.out.println("from HashTest hashcode: "+this.str.hashCode());
    	return this.str.hashCode();
    }
    
    @Override
    public boolean equals(Object obj) { 
    	System.out.println("from HashTest equals: "+this.str.equals(((HashTest)obj).str));
        if (obj instanceof HashTest) {
            HashTest ht = (HashTest) obj;
            
            return this.str.equals(ht.str);
        }
        return false;
    }
        
    public static void main(String args[]) {
        /*HashTest h1 = new HashTest("2");        
        String s1 = new String("1");        
        
        List<Object> list = new LinkedList<Object>();
        list.add(h1);
        list.add(s1);
        
        for (Object o : list) {
            System.out.print(o + " ");
        }*/
                HashTest h1 = new HashTest("1");
                HashTest h2 = new HashTest("1");
                String s1 = new String("2");
                String s2 = new String("3");
                System.out.println("Welcome to HashTest");
                HashSet<Object> hs = new HashSet<Object>();
                hs.add(h1);//System.out.println("from hs.add(h1)");
                hs.add(h2);//System.out.println("from hs.add(h2)");
                hs.add(s1);//System.out.println("from hs.add(s1)");
                hs.add(s2);//System.out.println("from hs.add(s2)");
                System.out.println(hs);
                
                System.out.println(hs.size());
                Object myObj = new String[]{"one", "two", "three"};{
                for (String s : (String[])myObj) System.out.print(s + ".");
                }
    }
}