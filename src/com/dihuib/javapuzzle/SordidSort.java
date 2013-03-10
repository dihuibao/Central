package com.dihuib.javapuzzle;

import java.util.Arrays;
import java.util.Comparator;

public class SordidSort {
	public static void main(String [] args) {
		Integer big = new Integer(2000000000);
		Integer small = new Integer(-2000000000);
		Integer zero = new Integer(0);
		
		Integer[] a = new Integer[] {big,small,zero };
		Arrays.sort(a, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Integer)o2).intValue()-
				((Integer)o1).intValue();
			}
		});
		
		System.out.println(Arrays.asList(a));
		System.out.println(a);
	}
}
