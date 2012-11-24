package com.dihuib.aspectj;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AspectJTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSimpleAspectJ() {
		MessageCommunicator messageCommunicator = new MessageCommunicator();
		messageCommunicator.deliver("Hello World");
		messageCommunicator.deliver("Allen", "Good Morning");

		//System.out.println("Last accessed time for messageCommunicator"
		//		+ messageCommunicator.getLastAccessedTime());
	}

}
