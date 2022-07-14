package com.jurgita.ebook.controllers;

import com.jurgita.ebook.models.Book;
import com.jurgita.ebook.models.BookDTO;
import com.jurgita.ebook.models.Genre;
import com.jurgita.ebook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getBooksForAdvertisement() {
        return ResponseEntity.ok(bookService.getBooksForAdvertisement());
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAll());
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Optional<Book>> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getById(id));
    }
    // by name, author, etc. ??

    @GetMapping("/books/genre")
    public ResponseEntity<List<Book>> getBookByGenre(@PathVariable Genre genre) {
        return ResponseEntity.ok(bookService.getByGenre(genre));
    }

    @PostMapping
    public void addBook(@RequestBody BookDTO book) {
        bookService.addNewBook(book);
    }

//    @PutMapping("/{bookId}")
//    public ResponseEntity<Void> editBook(@RequestBody BookDTO newBook,
//                                         @PathVariable Long bookId) {
//        bookService.updateBook(newBook, bookId);
//        return ResponseEntity.ok().build();
//    }

    @DeleteMapping("{id}")
    public void deleteBook() {

    }

}
