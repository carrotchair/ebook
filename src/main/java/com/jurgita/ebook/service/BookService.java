package com.jurgita.ebook.service;

import com.jurgita.ebook.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooksForAdvertisement() {
        final int min = 1;
        final int max = bookRepository.findAll().size();
        final int numberOfBooksInAdverts = 5;

        List<Integer> randomNumbers = getRandomNumbersUsingInts(min, max, numberOfBooksInAdverts);
        List<Long> randomNumbersToLong = randomNumbers.stream()
                .mapToLong(Integer::longValue)
                .boxed().toList();

        return bookRepository.findAllById(randomNumbersToLong);
    }

    public List<Integer> getRandomNumbersUsingInts(int min, int max, int numberOfBooksInAdverts) {
        Random random = new Random();
        List<Integer> randomNumbers = new ArrayList<>();

        random.ints(min, max).limit(numberOfBooksInAdverts)
                .forEach(randomNumbers::add);

        return randomNumbers;
    }
}
