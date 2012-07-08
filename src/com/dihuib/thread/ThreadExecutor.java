package com.dihuib.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class P2 implements Runnable{
	
	private int id;
	
	public P2(int id){
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("Start " +id);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Complete "+id);
	}
	
}

public class ThreadExecutor {
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		for(int i=0;i<5;i++){
			executor.submit(new P2(i));
		}
		
		executor.shutdown();
		
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("All tasks completed.");
	}
}
