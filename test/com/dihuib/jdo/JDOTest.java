package com.dihuib.jdo;

import java.util.ArrayList;
import java.util.Iterator;

import javax.jdo.JDOException;
import javax.jdo.PersistenceManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.objectdb.Utilities;

public class JDOTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testHellWorld() {
		PersistenceManager pm = Utilities.getPersistenceManager("objectdb/hello.odb");
		pm.currentTransaction().begin();

		Person person = new Person("Dihui","Bao",28);

		try {
			pm.makePersistent(person);
			pm.currentTransaction().commit();
			pm.close();
		} catch (JDOException e) {
			pm.currentTransaction().rollback();
		}		

	}

}
