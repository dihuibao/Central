package com.dihuib.jpa;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dihuib.jdo.Person;

public class JPATest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testJPA(){
		 EntityManagerFactory emf =
		      Persistence.createEntityManagerFactory("objectdb/world.odb");
		 EntityManager em = emf.createEntityManager();
		 
		 Person person = new Person("Yelu","Chen",27);
		 try{
			 em.getTransaction().begin();
			 em.persist(person);
			 em.getTransaction().commit();
		 }
		 finally{
			 if(em.getTransaction().isActive())
				 em.getTransaction().rollback();
		 }
	}

}
