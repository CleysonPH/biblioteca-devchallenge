package com.cleysonph.booksapi.controller;

import java.util.List;

import javax.validation.Valid;

import com.cleysonph.booksapi.exception.BookNotFoundException;
import com.cleysonph.booksapi.model.Book;
import com.cleysonph.booksapi.service.BookService;
import com.cleysonph.booksapi.dto.BookDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> index() {
        return bookService.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Book create(@RequestBody @Valid BookDTO bookDTO) {
        return bookService.create(bookDTO);
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable Long id) throws BookNotFoundException {
        return bookService.getById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws BookNotFoundException {
        bookService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Book replace(@RequestBody @Valid BookDTO bookDTO, @PathVariable Long id) throws BookNotFoundException {
        return bookService.replace(id, bookDTO);
    }

    @PatchMapping("/{id}")
    public Book update(@RequestBody Book book, @PathVariable Long id) throws BookNotFoundException {
        return bookService.update(id, book);
    }

}
