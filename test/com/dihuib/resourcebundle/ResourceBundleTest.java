package com.dihuib.resourcebundle;

import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class ResourceBundleTest {

	@Test
	public void testResourceBundle() {
		Locale locale = new Locale("zh", "CN");
		ResourceBundle rb = ResourceBundle.getBundle("com/dihuib/resourcebundle/myres", locale);
		assertThat(rb.getString("locale"), is("zh_CN"));
	}
	
	@Test
	public void testResourceBundle2() {
		Locale locale = new Locale("en", "US");
		ResourceBundle rb = ResourceBundle.getBundle("com/dihuib/resourcebundle/myres", locale);
		assertThat(rb.getString("locale"), is("en_US"));
	}
}
