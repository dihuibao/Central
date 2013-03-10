package com.dihuib.j2se;

import java.math.BigDecimal;
import java.math.MathContext;

import org.junit.Test;

public class BigDecimalTest {
	
	@Test
	public void testBigDecimal() {
		
		MathContext mc = new MathContext(10);
		
		mc = mc.DECIMAL32;
		
		BigDecimal nc = new BigDecimal(00.552,mc);
		
		System.out.println("BigDecimal value :" + nc + "\nmethod geernating result :" + nc.unscaledValue());
		
	}
}
