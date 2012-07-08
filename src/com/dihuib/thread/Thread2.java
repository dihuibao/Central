package com.dihuib.thread;

public class Thread2 {

	public static void main(String[] args) {
		Thread thread2 = new Thread(new Runnable(){

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
			
		});
		thread2.start();
	}
}
