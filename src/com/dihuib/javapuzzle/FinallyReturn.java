package com.dihuib.javapuzzle;

public class FinallyReturn {

	public static boolean ret() {
		try {
			return true;
		} finally {
			return false;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(ret());
	}
}
