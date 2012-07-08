package com.dihuib.aspectj.annotation;

import org.junit.Before;

//@Aspect
public class SecurityAspect {
	
	//@Pointcut("execution(* com.dihuib.aspectj.MessageCommunicator.deliver(..))")
	public void secureAccess(){}
	
	//@Before("secureAccess()")
	public void secure() {
		System.out.println("Checking and authenticating user with Aspectj annotation");
	}
}
