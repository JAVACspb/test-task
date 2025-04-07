package com.yourorganization.testtask.feature.book.repository;

import com.yourorganization.testtask.feature.book.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
    Page<Book> findByTitleContaining(String title, Pageable pageable);
    Book findByIsbn(String isbn);
}
