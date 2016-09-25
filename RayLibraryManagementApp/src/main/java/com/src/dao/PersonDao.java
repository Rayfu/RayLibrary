package com.src.dao;

import com.src.model.Person;

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
public class PersonDao {

    @PersistenceContext
    private EntityManager em;

    public void persist(Person person) {
        em.persist(person);
    }

    public List<Person> findAll() {
        return em.createQuery("SELECT p FROM Person p").getResultList();
    }

    public Person findById(int id) {
//            return em.find(Person.class, id);
        String query = "SELECT P FROM Person p " + "join fetch p.books " + " WHERE p.id =" + id;
        Person person = (Person) em.createQuery(query).getResultList().get(0);
        return person;
    }
}
