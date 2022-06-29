package com.jurgita.ebook.service;

import com.jurgita.ebook.models.Book;
import com.jurgita.ebook.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAll3() {
        return bookRepository.findAll();
    }

}
