package testReflect;

import java.awt.List;

public class Person {

	public String name = "ShawnFiend";
	private long user_ID = 12344312;
	private int age;
	private final int NUMBER = 5;
	
	public Person() {
		
	}
	
	public Person(String name, long user_ID, int age) {
		this.name = name;
		this.user_ID = user_ID;
		this.age = age;
		System.out.println("name: " + name + ", user id: " + user_ID);
	}
	
	private Person(List list) {
		System.out.println("Person in list");
	}
	
	
	public static void main(String[] args) {
		System.out.println("main...");
	}
	
	public Person[] community(Person[] community) {
		community = new Person[NUMBER];
		for (int i = 0; i < community.length; i++) {
			community[i] = new Person();
		}
		System.out.println("community is founded.");
		return new Person[]{};
	}
	
	public void register() {
		System.out.println("Person is registed.");
	}
	
	private void showInfo() {
		System.out.println(name + ":" + age);
	}

}
