package com.dihuib.h2;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dihuib.h2.domain.Event;
import com.dihuib.h2.domain.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:com/dihuib/h2/appContext.xml"})
public class H2Test {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Before
	public void setUp(){
	}
	
	@After
	public void tearDown(){
	}
	
	@Ignore
	@Test
	public void testH2() {
		
		JdbcTemplate template = new JdbcTemplate(dataSource);
		int nrRecords = template.queryForInt("SELECT COUNT(*) FROM PERSON");
		assertThat(nrRecords, is(2));
	}
	
	@Ignore
	@SuppressWarnings("unchecked")
	@Test
	public void testH2WithHibernate() {
		List<Person> pl=sessionFactory.openSession().createQuery("from Person person ")
        .list();
		
		System.out.println(pl.size());
		for(Person person: pl){
			System.out.println(person.getId()+":"+person.getLastName()+" "+person.getFirstName());
		}

	}
	
	
	@Ignore
	@Test
	public void testH2Save() {
		Person p = new Person();
		p.setId(10);
		p.setLastName("Zhang");
		p.setFirstName("San");
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.save(p);
		transaction.commit();		
		
		this.printPersonList();
		
	}
	
	@Test
	public void testAssocation() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Person p = (Person) session.load(Person.class, 1);
		for(Object o: p.getEvents()){
			System.out.println(((Event)o).getDescription());
		}
		
		session.getTransaction().commit();
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}	
	
	private void printPersonList() {
		List<Person> pl=sessionFactory.openSession().createQuery("from Person person ")
        .list();
		for(Person person: pl){
			System.out.println(person.getId()+":"+person.getLastName()+" "+person.getFirstName());
		}
	}
	
}
