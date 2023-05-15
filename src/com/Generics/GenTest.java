package com.Generics;

import java.util.*;

class Empty {   
}

class Extended extends Empty {  
}

public class GenTest {    
        public static void doStuff1(List<Empty> list) {
                System.out.println("doStruff1");
        }
        public static void doStuff2(List list) {        
        	System.out.println("doStruff2");
        }
        public static void doStuff3(List<? extends Empty> list) {
        	System.out.println("doStruff3");            
        }
        
        public static void main(String args[]) {
                List<Empty> list1 = new LinkedList<Empty>();
                List<Extended> list2 = new LinkedList<Extended>();
                
                doStuff1(list1);
                doStuff2(list2);
                doStuff2(list1);
                doStuff3(list1);
                doStuff3(list2);
                //doStuff1(list2);
        }
}
