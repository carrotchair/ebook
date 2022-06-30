package com.jurgita.ebook.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Year;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String author;
    private Year releaseYear;
    private int numberOfPages;
    private double pricePerUnit;

    //zrob w kontrolerze sprawdzanie wszystkich setterow na notnull i
    //tych dwoch pod katem mniej niz zero

//    public void setPricePerUnit(@NotNull double pricePerUnit) {
//        if(pricePerUnit < 0) {
//            throw new IllegalArgumentException("Price cannot be less than 0 (zero)");
//        }
//        this.pricePerUnit = pricePerUnit;
//    }
}
