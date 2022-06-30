package com.jurgita.ebook.models;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class RegularBook extends Book {

    private Long barcode;
    Genre genre;
}
