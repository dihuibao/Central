package com.dihuib.spring.timer;

import java.util.TimerTask;

public class MySchedule extends TimerTask {

	@Override
	public void run() {
		System.out.println("-----------Timer Starts---------------");

		try {
			System.out.println("Working.....");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("-----------Timer ends ----------------");

	}

}
