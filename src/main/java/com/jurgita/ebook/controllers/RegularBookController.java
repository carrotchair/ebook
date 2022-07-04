package com.jurgita.ebook.controllers;

import com.jurgita.ebook.models.Genre;
import com.jurgita.ebook.models.RegularBook;
import com.jurgita.ebook.service.RegularBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class RegularBookController {

    @Autowired
    RegularBookService regularBookService;

    @GetMapping
    public ResponseEntity<List<RegularBook>> getAllBooks() {
        return ResponseEntity.ok(regularBookService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<RegularBook>> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(regularBookService.getById(id));
    }
    // by name, author, etc. ??

    @GetMapping("/genre")
    public ResponseEntity<List<RegularBook>> getBookByGenre(@PathVariable Genre genre) {
        return ResponseEntity.ok(regularBookService.getByGenre(genre));
    }

    @PostMapping
    public void postBook() {

    }

    @PutMapping("/{id}")
    public void editBook() {

    }

    @DeleteMapping("{id}")
    public void deleteBook() {

    }
}
