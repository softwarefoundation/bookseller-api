package com.softwarefoundation.booksellerapi.repository;

import com.softwarefoundation.booksellerapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Long> {
}
