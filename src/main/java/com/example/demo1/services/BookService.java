package com.example.demo1.services;

import com.example.demo1.domain.Book;

public interface BookService {
    Iterable<Book> findAll();
}
