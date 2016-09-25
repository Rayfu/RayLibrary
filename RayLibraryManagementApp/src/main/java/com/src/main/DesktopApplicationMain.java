package com.src.main;

import com.src.model.Book;
import com.src.model.Person;
import com.src.service.BookService;
import com.src.service.PersonService;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

public class DesktopApplicationMain {
	
	public static void main(String[] args) {
		try{
		//Create Spring application context
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring.xml");
	
                Book book1 = new Book(1, "Java Coding Based on SOA", "Alex Spray", "ISBN-1127999");
                Book book2 = new Book(2, "Spring Framework Introduction", "Peter Black", "ISBN-1123339");
                Book book3 = new Book(3, "J2EE Introduction", "Mike Smith", "ISBN-1123339");
                Book book4 = new Book(4, "How to Develop Spring Application Using Java", "Mike Smith", "ISBN-1124559");
                Book book5 = new Book(5, "DO Your Best Learn J2EE and Spring", "Alex Black", "ISBN-17845539");
                
                Person person1 = new Person(1, "Alex Black", "6261019999", "alex.black@gmail.com");
                Person person2 = new Person(2, "Mike Spray", "222777772", "mike.spray@gmail.com");
                Person person3 = new Person(3, "Peter Smith", "929230405", "alex.black@gmail.com");
                
                PersonService personService = ctx.getBean(PersonService.class);
                BookService bookService = ctx.getBean(BookService.class);
                
                List<Book> books = new ArrayList();
                List<Book> books2 = new ArrayList();
                books.add(book1);
                books.add(book2);
                books.add(book3);
                person1.setBooks(books);
                books2.add(book4);
                books2.add(book5);
                person2.setBooks(books2);
                        
                personService.add(person1);
                personService.add(person2);
                
                Person result = personService.findById(1);
  	
		System.out.println("listAllPerson: " + personService.listAll().size());
		System.out.println("listAllBook: " + bookService.listAll().size());
		
		ctx.close();
                }
                catch(Exception ex)
                {
                    System.out.println(ex);
                }
		
	}
}
