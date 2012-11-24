package com.dihuib.enums;

import org.junit.Test;

public class EnumsTest {
	
	@Test
	public void testEnums() {
		System.out.println(FRUIT.APPLE.name());
	}
}

enum FRUIT {
	APPLE ("a"),
	ORANGE ("o");
	
	private String shortname;

	private FRUIT(String shortname) {
		this.shortname = shortname;
	}
	
	public static FRUIT value1Of(String shortname) {
		for(FRUIT fruit: FRUIT.values()){
			if(fruit.shortname.equals(shortname)){
				return fruit;
			}
		}
		return null;
	}
}
