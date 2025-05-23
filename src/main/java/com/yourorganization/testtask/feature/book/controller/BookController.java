package com.yourorganization.testtask.feature.book.controller;

import com.yourorganization.testtask.feature.book.dto.BookRequestDto;
import com.yourorganization.testtask.feature.book.dto.BookResponseDto;
import com.yourorganization.testtask.feature.book.service.BookService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/books/")
@Tag(name = "Books", description = "Операции с книгами")
public class BookController implements BookApi {

    private final BookService bookService;

    @Autowired
    public BookController(@Qualifier("bookServiceImpl1") BookService bookService) {
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

    @Override
    @GetMapping("/getByIsbn/{isbn}")
    public BookResponseDto getBookByIsbn(@PathVariable String isbn) {
        return bookService.findBookByIsbn(isbn);
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