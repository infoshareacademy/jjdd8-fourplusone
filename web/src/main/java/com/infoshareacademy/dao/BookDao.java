package com.infoshareacademy.dao;

import com.infoshareacademy.domain.entity.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BookDao {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());
@PersistenceContext
private EntityManager em;

    public Book getById(Long id) {return em.find(Book.class, id);}




    public void addBook(Book book) {

        em.persist(book);
        logger.info("New book was added :{}", book);
    }
}

