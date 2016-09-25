package com.src.dao;

import com.src.model.Book;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ray
 */
@Repository
public class BookDao {

    @PersistenceContext
    private EntityManager em;

    public void persist(Book book) {
        em.persist(book);
    }

    public List<Book> findAll() {
        return em.createQuery("SELECT p FROM Book p").getResultList();
    }

}
