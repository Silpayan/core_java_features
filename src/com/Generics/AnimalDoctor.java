package com.Generics;

	//Here is the entire example, complete with a test of the array polymorphism that
	//takes any type of animal array (Dog[], Cat[], Bird[]).

	abstract class Animal {
	public abstract void checkup();
	}
	class Dog extends Animal {
	public void checkup() { // implement Dog-specific code
	System.out.println("Dog checkup");
	}
	}
	class Catty extends Animal {
	public void checkup() { // implement Cat-specific code
	System.out.println("Cat checkup");
	}
	}
	
	
	class Bird extends Animal {
	public void checkup() { // implement Bird-specific code
	System.out.println("Bird checkup");
	}
	}
	
	public class AnimalDoctor {
	// method takes an array of any animal subtype
	public void checkAnimals(Animal[] animals) {
	for(Animal a : animals) {
	a.checkup();
	}
	}
	public static void main(String[] args) {
	// test it
	Dog[] dogs = {new Dog(), new Dog()};
	Catty[] cats = {new Catty(), new Catty(), new Catty()};
	Bird[] birds = {new Bird()};
	AnimalDoctor doc = new AnimalDoctor();
	doc.checkAnimals(dogs); // pass the Dog[]
	doc.checkAnimals(cats); // pass the Cat[]
	doc.checkAnimals(birds); // pass the Bird[]
	}
	}
