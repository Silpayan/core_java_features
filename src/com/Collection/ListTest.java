package com.Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ListTest {
    
    private String str;
    
    public ListTest(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
    	System.out.println("from ListTest toString");
        return str;
    }
    
    @Override
    public int hashCode() {             
    	System.out.println("from ListTest hashcode: "+this.str.hashCode());
    	return this.str.hashCode();
    }
    
//    @Override
//    public boolean equals(Object obj) { 
//    	System.out.println("from ListTest equals: "+this.str.equals(((ListTest)obj).str));
//        if (obj instanceof ListTest) {
//            ListTest ht = (ListTest) obj;
//            
//            return this.str.equals(ht.str);
//        }
//        return false;
//    }
        
    public static void main(String args[]) {
        /*ListTest h1 = new ListTest("2");        
        String s1 = new String("1");        
        
        List<Object> list = new LinkedList<Object>();
        list.add(h1);
        list.add(s1);
        
        for (Object o : list) {
            System.out.print(o + " ");
        }*/
                ListTest h1 = new ListTest("1");
                ListTest h2 = new ListTest("2");
                String s1 = new String("3");
                String s2 = new String("4");
                System.out.println("Welcome to ListTest");
                List<Object> l = new ArrayList<Object>();
                l.add(h1);//System.out.println("from l.add(h1)");
                l.add(h2);//System.out.println("from l.add(h2)");
                l.add(h2);
                l.add(s1);//System.out.println("from l.add(s1)");
                l.add(s2);//System.out.println("from l.add(s2)");
                
                System.out.println(l);
                System.out.println(l.size());
                
                l.remove(h2);
                System.out.println("index of h1 : "+l.indexOf(s1));
    
                Map<String, List<Object>> m = new HashMap<String, List<Object>>();
                m.put("s", l);
                
                l.add("5");
                System.out.println("final list"+l+"size = "+l.size());
                l = null; //??
                
                Object o = new Object();
                
                System.out.println("list from map"+m.get("s"));
                List<Student> aS = new ArrayList<Student>();
                Student st1 = new Student(1, "s1");
        		Student st2 = new Student(2, "s2");
        		Student st3 = new Student(3, "s3");
        		aS.add(st3);
        		aS.add(st1);
                aS.add(st2);
                Collections.sort(aS);
                StudentComparator stdC = new StudentComparator();
                System.out.println(aS);
                Collections.sort(aS, stdC);
                System.out.println(aS);
    }
}