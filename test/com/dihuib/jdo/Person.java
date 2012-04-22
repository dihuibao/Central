package com.dihuib.jdo;

import javax.jdo.annotations.PersistenceCapable;
import javax.persistence.Entity;

@PersistenceCapable
@Entity
public class Person {
	
	private String firstName;
	private String lastName;
	private int age;
	
	public Person() {}
	
	public Person(String firstName, String lastName, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName
				+ ", age=" + age + "]";
	}
	
}
