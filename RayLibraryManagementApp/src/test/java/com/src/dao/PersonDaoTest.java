/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.dao;

import com.src.model.Person;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.test.context.ContextConfiguration;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Ray
 */

@ContextConfiguration(locations = "classpath:spring.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class PersonDaoTest {
    
    public PersonDaoTest() {
    }
    
    @Autowired
    private PersonDao personDao;
    
    /**
     * Test of findAll method, of class PersonDao.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        List<Person> result = personDao.findAll();
        assertEquals(3, result.size());
    }

    /**
     * Test of findById method, of class PersonDao.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        int id = 1;
        Person result = personDao.findById(id);
        assertEquals("Alex Black", result.getName());
    }
    
}
