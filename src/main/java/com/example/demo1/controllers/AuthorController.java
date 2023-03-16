package com.example.demo1.controllers;

import com.example.demo1.services.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {
    private final AuthorService service;

    public AuthorController(AuthorService service) {
        this.service = service;
    }
@RequestMapping("/authors")
    public String getAuthors(Model model){
        model.addAttribute("authors" , service.findAll());
        return "authors";
    }
}
