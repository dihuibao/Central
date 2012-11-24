package com.dihuib.hello;

public class HelloWorld {
	public static void main(String args[]){
		//System.out.println("Hello World!");
		
		try{
			try{
				throw new IllegalStateException("A");
			}finally{
				System.out.println("final");
				try{
					//throw new Exception("C");
				}catch(IllegalStateException ex){
					throw new NullPointerException("B");
				}
			}
		}
		catch(IllegalStateException e){
			e.printStackTrace();
		}
		
	}
}
