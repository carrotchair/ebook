package com.jurgita.ebook.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EBook extends Book {

    private String device;
    // urzadzenie, na ktorym mozna przeczytac ebooka?
    // co ebooka wyroznia ?

}
