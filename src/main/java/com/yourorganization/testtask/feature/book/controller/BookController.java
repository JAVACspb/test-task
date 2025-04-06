package com.yourorganization.testtask.feature.book.controller;

import com.yourorganization.testtask.feature.book.dto.BookRequestDto;
import com.yourorganization.testtask.feature.book.dto.BookResponseDto;
import com.yourorganization.testtask.feature.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/create")
    public BookResponseDto createBook(@RequestBody @Valid BookRequestDto bookRequestDto) {
        return bookService.createBook(bookRequestDto);
    }

    @PutMapping("/update/{id}")
    public BookResponseDto updateBook(@PathVariable UUID id, @RequestBody @Valid BookRequestDto bookRequestDto) {
        return bookService.updateBook(id, bookRequestDto);
    }

    @GetMapping("/getAll")
    public Page<BookResponseDto> getAllBooks(Pageable pageable) {
        return bookService.listBooks(null, pageable);
    }

    @GetMapping("/getBy/{id}")
    public BookResponseDto getBookById(@PathVariable UUID id) {
        return bookService.findBookById(id);
    }

    @DeleteMapping("/deleteBy/{id}")
    public void deleteBook(@PathVariable UUID id) {
        bookService.deleteBook(id);
    }
}