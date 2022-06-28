package com.jurgita.ebook.controllers;

import com.jurgita.ebook.models.Book;
import com.jurgita.ebook.service.BookService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    BookService bookService;

    @GetMapping("")
    public List<Book> getAllBooks() {
        return bookService.all();
    }

    @GetMapping("/2")
    public CollectionModel<EntityModel<Book>> all() {
        return bookService.getAll();
    }

}
