package com.example.demo1.services;

import com.example.demo1.domain.Author;
import com.example.demo1.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService{
    private final AuthorRepository repository;

    public AuthorServiceImpl(AuthorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<Author> findAll() {
        return repository.findAll();
    }
}
