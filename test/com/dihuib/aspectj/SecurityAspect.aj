package com.dihuib.aspectj;

public aspect SecurityAspect {
	
	pointcut secureAccess()
	:execution(* MessageCommunicator.deliver(..));
	
	before(): secureAccess() {
		System.out.println("Checking and authenticating user");
	}

}
