package com.example.demo1.services;

import com.example.demo1.domain.Author;

public interface AuthorService {
    Iterable<Author> findAll();
}
