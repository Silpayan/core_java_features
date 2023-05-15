package com.Generics;

public class TrickyNum<X extends Number> {
    
    private X x;
    
    public TrickyNum(X x) {
        this.x = x;
    }
    
    private double getDouble(TrickyNum<? extends Number> a) {
        return x.doubleValue();
        //return 0;
    }
    
    private double getDoubleForObject() {
        return ((Double) x).doubleValue();
    }
    
    public static void main(String args[]) {
        TrickyNum<Integer> a = new TrickyNum<Integer>(new Integer(1));
        TrickyNum<Number> d = new TrickyNum<Number>(new Double(1));
        System.out.println(a.getDouble(a));
        System.out.println(a.getDouble(d));
        //System.out.print(a.getDoubleForObject());
    }
}