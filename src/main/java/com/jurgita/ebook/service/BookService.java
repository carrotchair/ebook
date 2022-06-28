package com.jurgita.ebook.service;

import com.jurgita.ebook.controllers.BookController;
import com.jurgita.ebook.models.Book;
import com.jurgita.ebook.models.BookModelAssembler;
import com.jurgita.ebook.repository.BookRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class BookService {

    private final BookRepository bookRepository;
    private final BookModelAssembler assembler;

    public BookService(BookRepository bookRepository, BookModelAssembler assembler) {
        this.bookRepository = bookRepository;
        this.assembler = assembler;
    }

    public List<Book> all() {
        return new ArrayList<>(bookRepository.findAll());
    }

    public CollectionModel<EntityModel<Book>> getAll() {
        List<EntityModel<Book>> books = bookRepository.findAll().stream()
                .map(assembler::toModel)
                .toList();

        return CollectionModel.of(books,
                linkTo(methodOn(BookController.class).all()).withSelfRel());
    }

}
