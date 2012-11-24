package com.dihuib.h2.domain;

import java.util.HashSet;
import java.util.Set;

public class Person {

	private int id;
	private String firstName;
	private String lastName;
	private Set events = new HashSet();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set getEvents() {
		return events;
	}

	public void setEvents(Set events) {
		this.events = events;
	}
	
	

}
