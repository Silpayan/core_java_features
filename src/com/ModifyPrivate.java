package com;

import java.util.Date;

class ModifyPrivate {
	@SuppressWarnings("deprecation")
	public static void main(String s[]){
		Persion p = new Persion("Silpayan", new Date(82,11,01), new Address(118, "Govt College Road", "Bangalore"));
		System.out.println(p);
		Date d = p.getDob();
		d.setMonth(8);
		Address a = p.getAddress();
		a.setCity("Kolkata");
		System.out.println(p);
		a = new Address(23, "Station Road ", "Konnagar");
		System.out.println(p);
	}

}

class Persion{
	private String Name;
	private final Date dob;
	private final Address address;
	Persion(String n, Date d, Address a){
		Name = n;
		dob = d;
		address = a;
	}

	public String getName(){
		return Name;
	}
	
	public Date getDob(){
		return dob;
	}
	
	public Address getAddress(){
		return address;
	}
	
	@Override
	public String toString() {
		return Name+" born on "+dob+" stay's "+address;
	}
}

class Address{
	
	int houseNo;
	String Street, City;
	
	Address(int hn, String s, String c){
		houseNo = hn;
		Street = s;
		City = c;
	}
	
	void setCity(String c){
		City = c;
	}
	
	@Override
	public String toString(){
		return houseNo+", "+Street+", "+City;
	}
}