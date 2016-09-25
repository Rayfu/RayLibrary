package com.src.service;

import com.src.dao.PersonDao;
import com.src.model.Person;

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
public class PersonService {

    @Autowired
    private PersonDao dao;

    @Transactional
    public void add(Person person) {
        dao.persist(person);
    }

    @Transactional
    public void addAll(Collection<Person> persons) {
        for (Person person : persons) {
            dao.persist(person);
        }
    }

    @Transactional(readOnly = true)
    public List<Person> listAll() {
        return dao.findAll();
    }

    @Transactional(readOnly = true)
    public Person findById(int id) {
        return dao.findById(id);
    }
}
