package com.jurgita.ebook.repository;

import com.jurgita.ebook.models.AntiqueBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AntiqueBookRepository extends JpaRepository<AntiqueBook, Long> {
}
