package com.dihuib.h2;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:com/dihuib/h2/appContext.xml"})
public class H2Test {

	@Autowired
	private DataSource dataSource;
	
	@Before
	public void setUp(){
	}
	
	@After
	public void tearDown(){
	}
	
	@Test
	public void testH2() {
		
		JdbcTemplate template = new JdbcTemplate(dataSource);
		int nrRecords = template.queryForInt("SELECT COUNT(*) FROM PERSON");
		assertThat(nrRecords, is(2));
		
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	
	
}
