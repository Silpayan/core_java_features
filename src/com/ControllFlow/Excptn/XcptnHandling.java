package com.ControllFlow.Excptn;


public class XcptnHandling {
    public static void main(String[] args) {//throws RuntimeException{
        System.out.println(xcptnM());
        finaly();
    }
    
    protected static void finaly() {
    	try {
	        if (false) {
	        } else {
	            System.exit(1);
	        }
		}finally {
			System.out.println("in finally");
		    //codetocleanup();
		}
	}
	@SuppressWarnings("finally")
	protected static int xcptnM() {
		try {
            f();
            return 1;
        } catch (InterruptedException e) {
            throw new InterruptedException();
            //return 2;
        } catch (RuntimeException e) {
            return 3;
        } catch (Exception e) {
            return 4;
        } finally {
            return 5;
        }
	}
    // InterruptedException is a direct subclass of Exception.
    static void f() throws InterruptedException {
        throw new InterruptedException("Time for lunch.");
    }
}

