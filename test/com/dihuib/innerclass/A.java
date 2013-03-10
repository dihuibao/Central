package com.dihuib.innerclass;

public class A {
	private String a = "String A";
	private B bb = new B();
	
	class B {
		private String a;
		
		public B() {
			B.this.a = A.this.a;
			System.out.println(a);
		}
	}
	
	public static void main(String[] args) {
		new A();
	}
}
