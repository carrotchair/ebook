package com.jurgita.ebook.databaseMethods;

import com.jurgita.ebook.models.AntiqueBook;
import com.jurgita.ebook.models.Genre;
import com.jurgita.ebook.models.RegularBook;
import com.jurgita.ebook.models.Type;
import com.jurgita.ebook.repository.AntiqueBookRepository;
import com.jurgita.ebook.repository.RegularBookRepository;
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

    RegularBook bookHobbit = RegularBook.builder()
            .type(Type.REGULAR)
            .name("The Hobbit")
            .author("J. R. R. Tolkien")
            .releaseYear(Year.of(2001))
            .numberOfPages(1200)
            .pricePerUnit(32)
            .barcode(123456L)
            .genre(Genre.FANTASY)
            .build();

    RegularBook bookLittlePrince = RegularBook.builder()
            .type(Type.REGULAR)
            .name("The Little Prince")
            .author("Antoine de Saint-Exupéry")
            .releaseYear(Year.of(2008))
            .numberOfPages(96)
            .pricePerUnit(9.98)
            .barcode(123123L)
            .build();

    AntiqueBook bookAntique = AntiqueBook.builder()
            .type(Type.ANTIQUE)
            .name("Antique Book")
            .author("Ceasar")
            .releaseYear(Year.of(520))
            .numberOfPages(23)
            .pricePerUnit(250)
            .barcode(234234L)
            .build();

    @Bean
    CommandLineRunner initDatabase(RegularBookRepository repository) {
        return args -> {
            log.info(message, repository.save(bookHobbit));
            log.info(message, repository.save(bookLittlePrince));
        };
    }

    @Bean
    CommandLineRunner initDatabaseAntique(AntiqueBookRepository repository) {
        return args -> {
            log.info(message, repository.save(bookAntique));
        };
    }

}
