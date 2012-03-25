package com.dihuib.aspectj.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SecurityAspect {
	
	@Pointcut("execution(* com.dihuib.aspectj.MessageCommunicator.deliver(..))")
	public void secureAccess(){}
	
	@Before("secureAccess()")
	public void secure() {
		System.out.println("Checking and authenticating user with Aspectj annotation");
	}
}
