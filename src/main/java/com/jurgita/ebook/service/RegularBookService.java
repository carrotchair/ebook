package com.jurgita.ebook.service;

import com.jurgita.ebook.models.Genre;
import com.jurgita.ebook.models.RegularBook;
import com.jurgita.ebook.repository.RegularBookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegularBookService {

    private final RegularBookRepository regularBookRepository;

    public RegularBookService(RegularBookRepository bookRepository) {
        this.regularBookRepository = bookRepository;
    }

    public List<RegularBook> getAll() {
        return regularBookRepository.findAll();
    }

    public Optional<RegularBook> getById(Long id) {
        return regularBookRepository.findById(id);
    }

    public List<RegularBook> getByGenre(Genre genre) {
        return regularBookRepository.findAll()
                .stream()
                .filter(regularBook -> regularBook.getGenre() == genre)
                .toList();
    }

}
