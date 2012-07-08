package com.dihuib.thread;

import java.util.Scanner;

class P extends Thread {

	private volatile boolean running = true;

	@Override
	public void run() {
		while (running) {
			System.out.println("Running");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void shutdown() {
		running = false;
	}
}

public class ThreadSync {
	public static void main(String[] args) {
		P p = new P();
		p.start();
		new Scanner(System.in).nextLine();
		p.shutdown();
	}
}
