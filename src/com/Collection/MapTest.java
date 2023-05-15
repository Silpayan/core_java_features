package com.Collection;

import java.util.*;


class DogMap {
	public DogMap(String n) { name = n; }
	public String name;
	
	public boolean equals(Object o) {
		System.out.println("from equals");
		if((o instanceof DogMap) && (((DogMap)o).name == name)) 
		{
		return true;
		} 
		else
		{
			return false;
		}
	}
	public int hashCode() {System.out.println("from hashCode "+name);return name.length(); }
	public String toString(){return this.name;}
}

	class Cat { }

	enum Pets {DOG, CAT, HORSE }

	class MapTest {
	public static void main(String[] args) {
	Map<Object, Object> m = new HashMap<Object, Object>();
	m.put("k1", new DogMap("aiko")); // add some key/value pairs
	m.put("k2", Pets.DOG);
	m.put(Pets.CAT, "CAT key");
	DogMap d1 = new DogMap("clover"); // let's keep this reference
	m.put(d1, "Dog key");
	DogMap d2 = new DogMap("clover");
	m.put(d2, "Dog Key2");
	m.put(1, "cat");
	m.put(2, "cat1");
	m.put(new Cat(), "Cat key");
	Set<Object> mapKeys = m.keySet();
	Collection<Object> mapValues = m.values();
	Iterator<Object> mapkey = mapKeys.iterator();
	Iterator<Object> mapValue = mapValues.iterator();
	int count = 0;
	/*do{
		count++;
		if(mapkey.hasNext())
			System.out.print("Key "+m.get(mapkey.next()));
		if(mapValue.hasNext())
			System.out.println(" Value "+mapValue.next());
	}while(count<m.size());*/
		
	System.out.println(m.get("k1")); // #1
	String k2 = "k2";
	System.out.println(m.get(k2)); // #2
	Pets p = Pets.CAT;
	System.out.println(m.get(p)); // #3
	System.out.println(m.get(d1)); // #4
	System.out.println(m.get(new Cat())); // #5
	System.out.println(m.size()); // #6
	System.out.println(m.get(1));
	System.out.println(m.get(2));
	}
}