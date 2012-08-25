package com.dihuib.annotation;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.dihuib.annotation.Test.TestType;

public class Foo {
	
	@Test(description="m100",type=TestType.B)
	public void m100(int param){
		System.out.println("normal method called with param " + param);
	}
	
	@Test public static void m1(){}
	public static void m2(){}
	
	@Test public static void m3(){
		throw new RuntimeException("Boom");
	}
	
	public static void m4(){}
	
	@Test public static void m5(){}
	
	public static void m6(){}
	
	@Test public static void m7(){
		throw new RuntimeException("Crash");
		
	}
	public static void m8(){}
	
	
	public static void main(String[] args) {
		
		
		for(Method m: Foo.class.getMethods()){
			if(m.isAnnotationPresent(Test.class)){
				Test testAnnocation = m.getAnnotation(Test.class);
				System.out.println(testAnnocation.description());
				try{
					int modifiers = m.getModifiers();
					if(Modifier.isStatic(modifiers)){
						m.invoke(null);
					}
					else{
						m.invoke(new Foo(), 100);
					}
					System.out.println("Invoking " + m.getName());
				}catch(Throwable ex) {
					System.out.println("invoke failed");
					//ex.printStackTrace();
				}
			}
		}
		
	}
	
}
