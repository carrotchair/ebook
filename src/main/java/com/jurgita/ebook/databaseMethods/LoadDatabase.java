package com.jurgita.ebook.databaseMethods;

import com.jurgita.ebook.models.Book;
import com.jurgita.ebook.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.Year;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    String message = "Preloading {}";

    Book bookHobbit = Book.builder()
            .id(1)
            .name("The Hobbit")
            .author("J. R. R. Tolkien")
            .releaseYear(Year.of(2001))
            .numberOfPages(1200)
            .pricePerUnit(32)
            .build();

    Book bookLittlePrince = Book.builder()
            .id(2)
            .name("The Little Prince")
            .author("Antoine de Saint-Exupéry")
            .releaseYear(Year.of(2008))
            .numberOfPages(96)
            .pricePerUnit(9.98)
            .build();

    CommandLineRunner initDatabase(BookRepository repository) {
        return args -> log.info(message, repository.save(bookHobbit));
    }

    /*
    CommandLineRunner initDatabase(BookRepository repository) {
        return args -> {
            log.info(message, repository.save(new Book("Aaa",
                    "T",
                    11113333, 10, 23.99)));
            log.info(message, repository.save(new Book("Bbb",
                    "T",
                    11114444, 4, 23.99)));
            log.info(message, repository.save(new Book("Ccc",
                    "T",
                    11115555, 4, 1.2)));
        };
    }
     */

}
