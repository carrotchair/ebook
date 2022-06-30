package com.jurgita.ebook.repository;

import com.jurgita.ebook.models.RegularBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegularBookRepository extends JpaRepository<RegularBook, Long> {
}
