package com.infoshareacademy.service;

import com.infoshareacademy.dao.BookDao;
import com.infoshareacademy.domain.entity.*;
import com.infoshareacademy.dto.BookDTO;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Set;

@Stateless
public class BookService {

    @Inject
    private AuthorService authorService;

    @Inject
    private KindService kindService;

    @Inject
    private EpochService epochService;

    @Inject
    private GenreService genreService;

    @Inject
    private BookDao bookDao;

    public void addBooks (Set<BookDTO> books)  {

        books
                .forEach(this::addBook);
    }

    public void addBook(BookDTO book) {

        String authorName = book.getAuthor();
        Author author = authorService.findOrAdd(authorName);

        String kindName = book.getKind();
        LiteratureKind kind = kindService.findOrAdd(kindName);

        String epochName = book.getEpoch();
        Epoch epoch = epochService.findOrAdd(epochName);

        String genreName = book.getGenre();
        Genre genre = genreService.findOrAdd(genreName);

        Book bookDaoToEntity = new Book();

        bookDaoToEntity.setAuthor(author);
        System.out.println("Autor: "+author.getName());
        bookDaoToEntity.setKind(kind);
        System.out.println("Kind: "+kind.getName());
        bookDaoToEntity.setEpoch(epoch);
        System.out.println("Epoch: "+genre.getName());
        bookDaoToEntity.setGenre(genre);
        System.out.println("Genre: "+genre.getName());
        bookDaoToEntity.setTitle(book.getTitle());
        System.out.println("Title: "+book.getTitle());
        bookDaoToEntity.setCover(book.getCover());
        System.out.println("Cover: "+book.getCover());
        bookDaoToEntity.setCoverThumb(book.getCoverThumb());
        System.out.println("CoverThumb: "+book.getCoverThumb());
        bookDaoToEntity.setSimpleThumb(book.getSimpleThumb());
        System.out.println("SimpleThumb: "+book.getSimpleThumb());
        bookDaoToEntity.setHasAudio(book.getHasAudio());
        System.out.println("Audio: "+book.getHasAudio());

        bookDao.addBook(bookDaoToEntity);
    }
}