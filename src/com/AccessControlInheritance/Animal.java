package com.AccessControlInheritance;

import com.mycompany.Hotel;

public class Animal extends Creature {
    public Animal(int legCount) {
    	super(legCount);
        this.wingCount = 0;
        Hotel h = new Hotel();
        int x = h.roomNr;
    }
}