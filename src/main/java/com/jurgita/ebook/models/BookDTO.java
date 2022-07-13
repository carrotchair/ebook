package com.jurgita.ebook.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Year;

public class BookDTO {
    @Id
    @GeneratedValue
    private long id;
    private TypeOfProduct typeOfProduct;
    private String name;
    private String author;
    private Year releaseYear;
    private int numberOfPages;
    private String language;
    private double pricePerUnit;

    private Long barcode;
    private Genre genre; //is for regular book and ebook
    private Category category; //is for newspapers
    private Long scienceIndex; //is for science journal
}
