package com.dihuib.generics;

class Box<T>{
	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
	public <U extends Number> void inspect(U u){
		System.out.println(t.getClass().getName());
		System.out.println(u.getClass().getName());
	}
	
}

class A{}
interface B{}
interface C{}

class D<T extends A & B & C >{
	
}


public class App {	
	
	
	public static void main(String[] args) {
		Box<Integer> box1 = new Box<Integer>();
		Box<String> box2 = new Box<String>();
		box1.setT(13);
		System.out.println(box1.getT());
		box2.setT("Hello");
		System.out.println(box2.getT());
		
		Box rawBox = new Box();
		
		Box<String> box3 = rawBox;
		box1.inspect(10);
		
		
	}
}
