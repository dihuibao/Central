package com.dihuib.jaxb;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.Ignore;
import org.junit.Test;


public class JAXBTest {
	
	@Test
	public void testMarshall() throws JAXBException{
		Book book = new Book();
		book.setAuthor("AUTHOR");
		book.setName("BOOK");
		book.setPublisher("PUBLISHER");
		book.setIsbn("ISBN");
		
		JAXBContext context = JAXBContext.newInstance(Book.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(book, System.out);
	}
	
	@Test
	public void testMarshallList() throws JAXBException{
		ArrayList<Book> bookList = new ArrayList<Book>();
		
		Book book = new Book();
		book.setAuthor("AUTHOR");
		book.setName("BOOK");
		book.setPublisher("PUBLISHER");
		book.setIsbn("ISBN");
		
		bookList.add(book);
		
		BookStore bookStore = new BookStore();
		bookStore.setName("BOOKSTORE");
		bookStore.setLocation("LOCATION");
		bookStore.setBookList(bookList);
		
		JAXBContext context = JAXBContext.newInstance(BookStore.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(bookStore, System.out);
	}
	
	@Test
	public void testUnmarshall() throws JAXBException, FileNotFoundException {
		
		JAXBContext context = JAXBContext.newInstance(Book.class);
		Unmarshaller um = context.createUnmarshaller();
		
		Book book = (Book)um.unmarshal(new FileInputStream("test/com/dihuib/jaxb/book.xml"));
		
		System.out.println("publicher: "+book.getPublisher());
	}
}
