package com.annotationReflection;

import java.lang.annotation.*;
import java.lang.reflect.*;

/**
 * Indicates that the annotated method is a test method.
 * This annotation should be used only on parameterless static methods.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Test { }

class Foo {
    @Test public static void m1(int i) { }
    public static void m2() { }
    @Test public static void m3() {
        throw new RuntimeException("Boom");
    }
    public static void m4() { }
    @Test public static void m5() { }
    public static void m6() { }
    @Test public static void m7() {
        throw new RuntimeException("Crash");
    }
    public static void m8() { }
}


public class RunTest {
	   public static void main(String[] args) throws Exception {
	      int passed = 0, failed = 0;
	      for (Method m : Class.forName("com.annotationReflection.Foo").getMethods()) {
	    	  
	         if (m.isAnnotationPresent(Test.class)) {
	            try {
	               System.out.println("@Test Method "+m.getName());
	               if("m1".equals(m.getName()))
	            	   m.invoke(9);
	               else 
	            	   m.invoke(null);
	               passed++;
	            } catch (Throwable ex) {
	               System.out.printf("Test %s failed: %s %n", m, ex.getCause());
	               failed++;
	            }
	         }
	         else
	        	 System.out.println("Pati Method "+m.getName());
	      }
	      System.out.printf("Passed: %d, Failed %d%n", passed, failed);
	   }
	}