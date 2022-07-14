package com.jurgita.ebook.service;

import com.jurgita.ebook.mapper.BookMapper;
import com.jurgita.ebook.models.Book;
import com.jurgita.ebook.models.BookDTO;
import com.jurgita.ebook.models.Genre;
import com.jurgita.ebook.repository.BookRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@Mapper
public class BookService {

    private static final Logger LOGGER = LogManager.getLogger(BookService.class);

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

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> getById(Long id) {
        return bookRepository.findById(id);
    }

    public List<Book> getByGenre(Genre genre) {
        return bookRepository.findAll()
                .stream()
                .filter(book -> book.getGenre() == genre)
                .toList();
    }

    public void addNewBook(BookDTO bookDTO) {
        //var book = BookMapper.getInstance().bookDTOToBook(bookDTO);
        Book book2 = BookMapper.INSTANCE.bookDTOToBook(bookDTO);
        bookRepository.save(book2);
    }

//    public void updateBook(BookDTO bookDTO, Long bookId) {
//        Book newBook = BookMapper.INSTANCE.bookDTOToBook(bookDTO);
//
//        if (bookRepository.findById(bookId).isEmpty()) {
//            LOGGER.error("User tried to update an unexisting book ");
//            throw new BookNotFoundException(bookId);
//        } else {
//            bookRepository.findById(bookId)
//                    .map(b -> {
//                        b.setTypeOfProduct(newBook.getTypeOfProduct());
//                        b.setName(newBook.getName());
//                        b.setAuthor(newBook.getAuthor());
//                        b.setReleaseYear(newBook.getReleaseYear());
//                        b.setNumberOfPages(newBook.getNumberOfPages());
//                        b.setLanguage(newBook.getLanguage());
//                        b.setPricePerUnit(newBook.getPricePerUnit());
//
//                        b.setBarcode(newBook.getBarcode());
//                        b.setGenre(newBook.getGenre());
//                        b.setCategory(newBook.getCategory());
//                        b.setScienceIndex(newBook.getScienceIndex());
//                        return bookRepository.save(b);
//                    })
//                    .orElseGet(() -> {
//                        newBook.setBookId(bookId);
//                        return bookRepository.save(newBook);
//                    });
//        }
//    }
}
