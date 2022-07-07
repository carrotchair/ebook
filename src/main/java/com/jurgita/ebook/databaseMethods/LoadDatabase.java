package com.jurgita.ebook.databaseMethods;

import com.jurgita.ebook.models.Book;
import com.jurgita.ebook.models.Genre;
import com.jurgita.ebook.models.TypeOfProduct;
import com.jurgita.ebook.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Year;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    String message = "Preloading {}";

    Book bookHobbit = Book.builder()
            .typeOfProduct(TypeOfProduct.REGULAR_BOOK)
            .name("The Hobbit")
            .author("J. R. R. Tolkien")
            .releaseYear(Year.of(2001))
            .numberOfPages(1200)
            .pricePerUnit(32)
            .barcode(123456L)
            .genre(Genre.FANTASY)
            .build();

    Book bookLittlePrince = Book.builder()
            .typeOfProduct(TypeOfProduct.REGULAR_BOOK)
            .name("The Little Prince")
            .author("Antoine de Saint-Exupéry")
            .releaseYear(Year.of(2008))
            .numberOfPages(96)
            .pricePerUnit(9.98)
            .barcode(123123L)
            .build();

    @Bean
    CommandLineRunner initDatabase(BookRepository repository) {
        return args -> {
            log.info(message, repository.save(bookHobbit));
            log.info(message, repository.save(bookLittlePrince));
        };
    }

}
