package com.example.demo1.services;

import com.example.demo1.domain.Book;
import com.example.demo1.repositories.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<Book> findAll() {
        return repository.findAll();
    }
}
