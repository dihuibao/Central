package com.dihuib.hello;

import java.util.ArrayList;
import java.util.List;

public class Test {
	
	public int [] list = new int[20];
	
	public Test() {
		
	}
	
	
	public int fibo(int n){
		if(list[n]>0) {
			return list[n];
		}
		if(n==0 || n==1) {
			list[n]= 1;
			return 1;
		}
		else {
			int value = fibo(n-1) + fibo(n-2);
			list[n] = value;
			return value;
		}
	}
	
	public void printList() {
		for(Integer i: list) {
			System.out.println(i.intValue());
		}
	}
	
	public static void main(String [] args) {
		Test t = new Test();
		t.fibo(10);
		t.printList();
	}

}
