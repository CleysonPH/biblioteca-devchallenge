package com.cleysonph.booksapi.repository;

import com.cleysonph.booksapi.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
