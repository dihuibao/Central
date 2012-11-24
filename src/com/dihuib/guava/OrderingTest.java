package com.dihuib.guava;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.dihuib.guava.model.EmailTemplate;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

public class OrderingTest {

	@Test
	public void testOrdering() {
		
		Function<EmailTemplate,String> GET_NAME = new Function<EmailTemplate,String>() {

			@Override
			public String apply(EmailTemplate input) {	
				return input.getEmail();
			}
			
		};
		
		//Ordering<EmailTemplate> order = Ordering.natural().nullsFirst().onResultOf(GET_NAME).compound(Ordering.arbitrary()).nullsFirst();
		Ordering<EmailTemplate> order = Ordering.natural().onResultOf(GET_NAME).nullsFirst();
		
		List<EmailTemplate> list = Lists.newArrayList(new EmailTemplate("dmssasas@hotmail.com"),null,new EmailTemplate("dihui","abalone.bdh@gmail.com"),new EmailTemplate("dihui","abalone_bdh@hotmail.com"));
		
		Collections.sort(list,order);
		
		for(EmailTemplate et: list){
			if(et!=null)
				System.out.println(et.toString());
			else
				System.out.println("null");
		}
	}
}
