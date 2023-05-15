package com.Initialization;

public class InstantVar {
    private Integer value = 1;
    
    public Integer getValue() {
        return value;
    }
    
    public int changeVal(Integer value) {
        value = new Integer(3);
        return value;
    }

    public static void main(String args[]) {
        Integer a = new Integer(2);
        InstantVar c = new InstantVar();
        System.out.print(c.changeVal(a));
    }
}
