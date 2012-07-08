package com.dihuib.thread;

class Runner extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Count: " + i);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class Thread1 {

	public static void main(String[] args) {
		Runner runner1 = new Runner();
		runner1.start();
		
		System.out.println("Hello");
	}
}
