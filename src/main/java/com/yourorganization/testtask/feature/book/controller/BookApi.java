package com.yourorganization.testtask.feature.book.controller;

import com.yourorganization.testtask.feature.book.dto.BookRequestDto;
import com.yourorganization.testtask.feature.book.dto.BookResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface BookApi {
    BookResponseDto createBook(BookRequestDto bookRequestDto);
    BookResponseDto updateBook(UUID id, BookRequestDto bookRequestDto);
    BookResponseDto getBookById(UUID id);
    void deleteBook(UUID id);
    Page<BookResponseDto> getAllBooks(Pageable pageable);
    BookResponseDto getBookByIsbn(String isbn);
}
