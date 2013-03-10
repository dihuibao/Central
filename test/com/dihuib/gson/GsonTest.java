package com.dihuib.gson;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.lang.reflect.Type;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GsonTest {
	
	Gson gson;
	
	@Before
	public void setUp() {
		gson = new Gson();
	}
	
	@Test
	public void testSerialization() {
		assertThat(gson.toJson(1),is("1"));
		assertThat(gson.toJson("abcd"),is("\"abcd\""));
		assertThat(gson.toJson(new Long(10)),is("10"));
		int [] values = {1};
		assertThat(gson.toJson(values),is("[1]"));
	}
	
	@Test
	public void testDeserialization() {
		int one = gson.fromJson("1", int.class);
		assertThat(one, is(1));
		Integer oneInt = gson.fromJson("1", Integer.class);
		assertThat(oneInt, is(1));
		Long oneLong = gson.fromJson("1", Long.class);
		assertThat(oneLong, is(1L));
		String str = gson.fromJson("\"abc\"", String.class);
		assertThat(str,is("abc"));
		String[] anotherStr = gson.fromJson("[\"abc\"]", String[].class);
		assertThat(anotherStr,is(new String[] {"abc"}));
	}
	
	@Test
	public void testObject() {
		BagOfPrimitives obj = new BagOfPrimitives();
		assertThat(gson.toJson(obj),is("{\"value1\":1,\"value2\":\"abc\"}"));
		
		BagOfPrimitives obj2 = gson.fromJson("{\"value1\":  1,\"value2\":\"abc\"}", BagOfPrimitives.class);
		assertThat(obj2,is(obj));
	}
	
	@Ignore
	@Test
	public void testInner() {
		Outer outer = new Outer();
		System.out.println();
		System.out.println(gson.toJson(outer));
	}
	
	@Test
	public void testGenerics() {
	}
}
