package com.softwarefoundation.booksellerapi.service;

import com.softwarefoundation.booksellerapi.model.Book;

import java.util.List;

public interface IBookService {
    Book saveBook(Book book);

    void deleteBook(Long id);

    List<Book> findAllBooks();
}
