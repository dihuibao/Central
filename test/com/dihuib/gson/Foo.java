package com.dihuib.gson;

public class Foo<T> {
	T value;
	
	private Class<T> clazz;
	
	public Foo(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	public T buildOne() throws InstantiationException, IllegalAccessException {
		return clazz.newInstance();
	}
}
