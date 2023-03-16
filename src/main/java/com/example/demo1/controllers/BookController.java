package com.example.demo1.controllers;

import com.example.demo1.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){
        model.addAttribute("books", service.findAll());
        return "books";
    }
}
