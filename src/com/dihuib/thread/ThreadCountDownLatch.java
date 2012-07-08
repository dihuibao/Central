package com.dihuib.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class P3 implements Runnable {
	private CountDownLatch latch;

	public P3(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {

		System.out.println("Start ");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		latch.countDown();
		System.out.println("Complete ");
	}

}

public class ThreadCountDownLatch {
	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);

		ExecutorService executor = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 5; i++) {
			executor.submit(new P3(latch));
		}

		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("All tasks completed.");
	}
}
