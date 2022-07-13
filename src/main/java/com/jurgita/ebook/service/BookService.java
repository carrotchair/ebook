package com.jurgita.ebook.service;

import com.jurgita.ebook.models.Book;
import com.jurgita.ebook.models.Genre;
import com.jurgita.ebook.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private ModelMapper modelMapper;

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

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> getById(Long id) {
        return bookRepository.findById(id);
    }

    public List<Book> getByGenre(Genre genre) {
        return bookRepository.findAll()
                .stream()
                .filter(regularBook -> regularBook.getGenre() == genre)
                .toList();
    }

    public void addNewBook(Book book) {
        
        bookRepository.save(book);
    }

    public void updateBook(Book newBook, Long bookId) {
        final var book = bookRepository.findById(bookId);

    }
}
