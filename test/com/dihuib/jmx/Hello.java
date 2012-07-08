package com.dihuib.jmx;


public class Hello implements HelloMBean{

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void printHello(){
		System.out.println("hello");
	}
	
	public void printHello(String name) {
		System.out.println("Hello, "+ name);
	}
}
