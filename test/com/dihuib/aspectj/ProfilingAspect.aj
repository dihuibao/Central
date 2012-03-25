package com.dihuib.aspectj;

public aspect ProfilingAspect {
	pointcut publicOperation() : execution(* MessageCommunicator.*(..));

	Object around() : publicOperation() {
		long start = System.nanoTime();
		Object ret = proceed();
		long end = System.nanoTime();
		System.out.println(thisJoinPointStaticPart.getSignature() + " took "
				+ (end - start) + " nanoseconds");
		return ret;
	}
}
