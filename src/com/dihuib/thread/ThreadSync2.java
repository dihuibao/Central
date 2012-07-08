package com.dihuib.thread;

public class ThreadSync2 {
	
	Object lock1 = new Object();
	Object lock2 = new Object();

	public void task1() {
		synchronized(lock1){
			this.sleep();
		}
		
	}

	public void task2() {
		synchronized(lock2){
			this.sleep();
		}
	}

	public void sleep() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void process() {
		this.task1();
		this.task2();
	}
	
	public void run() {
		long start = System.currentTimeMillis();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=0;i<10;i++){
					process();
				}
			}

		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=0;i<10;i++){
					process();
				}
			}

		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(System.currentTimeMillis()-start);
	}

	public static void main(String[] args) {
		ThreadSync2 t = new ThreadSync2();
		t.run();
	}
}
