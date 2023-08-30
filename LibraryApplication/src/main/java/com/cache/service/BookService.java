package com.cache.service;


import com.cache.entities.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookService {
    Book addBook(Book book);

    Book updateBook(Book book);

    Book getBook(long id);

    String deleteBook(long id);

    List<Book> getAllBooks();
}
