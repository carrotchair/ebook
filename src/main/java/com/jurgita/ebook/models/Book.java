package com.jurgita.ebook.models;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Year;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
class Book {

    @Id
    @GeneratedValue
    private long id;
    private Type type;
    private String name;
    private String author;
    private Year releaseYear;
    private int numberOfPages;
    private String language;
    private double pricePerUnit;

    private void pricePerUnitRange(double pricePerUnit) {
        if(pricePerUnit < 0) {
            throw new IllegalArgumentException("Price cannot be less than 0 (zero)");
        }
        this.pricePerUnit = pricePerUnit;
    }

    public void setPricePerUnit(@NotNull double pricePerUnit) {
        pricePerUnitRange(pricePerUnit);
    }
}
