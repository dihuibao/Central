package com.dihuib.collection;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CollectionTest {
	
	@Test
	public void testCollection() {
		List<String> c = new ArrayList<String>(3);
		c.add("A");
		c.add("B");
		c.add("C");
		c.add("D");
		
		
		for(String str : c) {
			System.out.println(str);
		}
		System.out.println(c.size());
	}

}
