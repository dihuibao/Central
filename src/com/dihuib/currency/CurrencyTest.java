package com.dihuib.currency;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

import org.junit.Test;

public class CurrencyTest {
	
	@Test
	public void testCurrency() {
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("fr", "FR"));  
		nf.setCurrency(Currency.getInstance("FRF"));  
		 
		System.out.println(nf.format(3.56));
	}
}
