package com.src.service;

import com.src.dao.BookDao;
import com.src.model.Book;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ray
 */

@Service
public class BookService {

    @Autowired
    private BookDao dao;

    @Transactional
    public void add(Book product) {
        dao.persist(product);
    }

    @Transactional
    public void addAll(Collection<Book> books) {
        for (Book book : books) {
            dao.persist(book);
        }
    }

    @Transactional(readOnly = true)
    public List<Book> listAll() {
        return dao.findAll();
    }
}
