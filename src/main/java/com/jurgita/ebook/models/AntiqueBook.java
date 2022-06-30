package com.jurgita.ebook.models;

import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.Entity;
import java.time.Year;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class AntiqueBook extends RegularBook {

    private static final Logger LOGGER = LogManager.getLogger(AntiqueBook.class);

    private final Year lastYear = Year.of(1900);
    private Year releaseYear;

    private void releaseYearRange(Year releaseYear) {
        if (releaseYear.isBefore(lastYear)) {
            this.releaseYear = releaseYear;
        } else {
            this.releaseYear = Year.of(1899);
            LOGGER.error("Antique book can be released no more recent than 1900 ");
        }
    }

    public Year getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(@NotNull Year releaseYear) {
        releaseYearRange(releaseYear);
    }
}
