package com.jurgita.ebook.repository;

import com.jurgita.ebook.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
