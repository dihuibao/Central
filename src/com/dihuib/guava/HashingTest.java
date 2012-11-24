package com.dihuib.guava;

import org.junit.Test;

import com.google.common.hash.Hashing;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class HashingTest {

	private static final int N = 4;
	@Test
	public void testConsistentHashing() {
		int bucket1 = Hashing.consistentHash(Hashing.md5().hashString("server2"),N);	
		int bucket2 = Hashing.consistentHash(Hashing.md5().hashString("server2"),N-1);
		
		assertThat(bucket1,is(equalTo(bucket2)));
	}
}
