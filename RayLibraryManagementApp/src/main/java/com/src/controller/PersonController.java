package com.src.controller;

import com.src.model.Book;
import com.src.model.Person;
import com.src.service.BookService;
import com.src.service.PersonService;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 *
 * @author Ray
 */
@Controller
public class PersonController {

    @Autowired
    PersonService personService;

    @Autowired
    BookService bookService;

    public PersonController() {
    }

    /**
     * Retrieve all persons
     *
     */
    public List<Person> populatePersonList() {
        List<Person> personList = personService.listAll();
        return personList;
    }

    /**
     * Retrieve all books
     *
     */
    public List<Book> populateBookList() {
        List<Book> books = bookService.listAll();
        return books;
    }

    /**
     * Method will be called in initial page load at GET /library
     *
     */
    @RequestMapping(value = "/library", method = RequestMethod.GET)
    public String setupForm(Model model) {
        model.addAttribute("persons", populatePersonList());

        model.addAttribute("books", populateBookList());

        return "listPersonView";
    }

    /**
     * Method will be called in initial page load at GET
     * /library/getBooksByPersonId
     *
     */
    @RequestMapping(value = "/library/getBooksByPersonId/{id}", method = RequestMethod.GET)
    public @ResponseBody
    List<Book> getBooksByPersonId(@PathVariable("id") int id) {
        List<Book> personBooks = new ArrayList();
        try {
            Person person = personService.findById(id);
            personBooks = person.getBooks();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return personBooks;
    }
    /**
     * Method will be called on submitting add person form POST
     * /person
     *
     */
//	@RequestMapping(method = RequestMethod.POST)
//	public String submitForm(@ModelAttribute("person") Person personVO,
//			BindingResult result, SessionStatus status) {
//
//            // Add JSR-303 errors to BindingResult
//            // This allows Spring to display them in view via a FieldError
//            result.addError(new FieldError("person", propertyPath, "Invalid "+ propertyPath + "(" + message + ")"));
//
//		if (result.hasErrors()) {
//			return "listPersonView";
//		}
//		// Mark Session Complete and redirect to URL so that page refresh do not re-submit the form
//		status.setComplete();
//		return "redirect:employee-module";
//	}
}
