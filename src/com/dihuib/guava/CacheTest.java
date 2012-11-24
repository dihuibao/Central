package com.dihuib.guava;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.junit.Ignore;
import org.junit.Test;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class CacheTest {
	
	public static int version = 0;

	private String createEntry(Integer i) {
		System.out.println("create entry #" + i);
		return "ENTRY#" + i;
	}

	@Ignore
	@Test
	public void testCache() {
		LoadingCache<Integer, String> cache = CacheBuilder.newBuilder()
				.maximumSize(1000).build(new CacheLoader<Integer, String>() {
					public String load(Integer key) throws Exception {
						return createEntry(key);
					}
				});

		try {
			cache.get(1);
			cache.get(2);
			cache.get(3);
			cache.get(4);
			cache.get(5);

			cache.get(1);
			cache.get(2);
			cache.get(3);
			cache.get(4);
			cache.get(5);

		} catch (ExecutionException e) {
		}
	}
	
	@Test
	public void testSupplier() throws InterruptedException {
		Supplier<String> supp = Suppliers.memoizeWithExpiration(stringSupplier(), 3, TimeUnit.SECONDS);
		
		supp.get();
		
		Thread.sleep(1000);
		
		supp.get();
		Thread.sleep(3000);
		supp.get();
		Thread.sleep(5000);
		supp.get();
		
	}
	
	private Supplier<String> stringSupplier(){
		return new Supplier<String>(){

			@Override
			public String get() {
				System.out.println("get cache"+  ++version);
				return "CACHED"+version;
			}
			
		};
	}
}
