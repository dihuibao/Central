package com.dihuib.saaj;

import java.io.IOException;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.junit.Test;

public class SAAJTest {
	
	@Test
	public void testSAAJ() throws SOAPException, IOException {
		MessageFactory msgFactory = MessageFactory.newInstance();
		
		SOAPMessage message = msgFactory.createMessage();
		message.getSOAPHeader().detachNode();
		
		SOAPBody body = message.getSOAPBody();
		SOAPElement getMessage = body.addChildElement("getMessage", "ns", "http://www.dihuib.com/saaj/test");
		getMessage.setEncodingStyle(SOAPConstants.URI_NS_SOAP_ENCODING);
		
		SOAPElement msg = getMessage.addChildElement("msg");
		msg.addTextNode("Hello World");
		message.writeTo(System.out);
	}
}
