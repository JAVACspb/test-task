package com.yourorganization.testtask.feature.book.service;

import com.yourorganization.testtask.feature.book.dto.BookRequestDto;
import com.yourorganization.testtask.feature.book.dto.BookResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface BookService {
    BookResponseDto createBook(BookRequestDto dto);
    BookResponseDto updateBook(UUID id, BookRequestDto dto);
    BookResponseDto findBookById(UUID id);
    void deleteBook(UUID id);
    Page<BookResponseDto> listBooks(String titleFilter, Pageable pageable);
    BookResponseDto findBookByIsbn(String isbn);
}
