package com.cleysonph.booksapi.service;

import java.util.List;

import com.cleysonph.booksapi.exceptions.BookNotFoundException;
import com.cleysonph.booksapi.model.Book;
import com.cleysonph.booksapi.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book create(Book book) {
        return bookRepository.save(book);
    }

    public Book getById(Long id) throws BookNotFoundException {
        return bookRepository.findById(id)
            .orElseThrow(() -> new BookNotFoundException("Book with ID " + id + " not found"));
    }

    public void deleteById(Long id) throws BookNotFoundException {
        bookRepository.delete(getById(id));
    }

    public Book replace(Long id, Book book) throws BookNotFoundException {
        getById(id);
        book.setId(id);
        return bookRepository.save(book);
    }

    public Book update(Long id, Book book) throws BookNotFoundException {
        Book bookToUpdate = getById(id);

        if (book.getTitle() != null) {
            bookToUpdate.setTitle(book.getTitle());
        }
        if (book.getPublisher() != null) {
            bookToUpdate.setPublisher(book.getPublisher());
        }
        if (book.getPhoto() != null) {
            bookToUpdate.setPhoto(book.getPhoto());
        }

        return bookRepository.save(bookToUpdate);
    }

}
