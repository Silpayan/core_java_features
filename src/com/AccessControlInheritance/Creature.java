package com.AccessControlInheritance;

public class Creature {
    private int legCount;
    protected int wingCount;
    
    public Creature(int legCount) {
        this.legCount = this.legCount;
        this.wingCount = 0;
    }
    
    public String toString() {
        return "legs=" + this.legCount + " wings=" + wingCount;
    }
}

