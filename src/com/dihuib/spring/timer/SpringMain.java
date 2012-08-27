package com.dihuib.spring.timer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(new String[] {"classpath:com/dihuib/spring/timer/timerContext.xml"});
		
		Thread.sleep(100000);
	}

}
