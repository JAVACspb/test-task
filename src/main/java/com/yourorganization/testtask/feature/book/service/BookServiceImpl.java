package com.yourorganization.testtask.feature.book.service;

import com.yourorganization.testtask.exeption.type.book.BookNotFoundException;
import com.yourorganization.testtask.exeption.type.book.InvalidBookDataException;
import com.yourorganization.testtask.feature.book.dto.BookRequestDto;
import com.yourorganization.testtask.feature.book.dto.BookResponseDto;
import com.yourorganization.testtask.feature.book.mapper.BookMapper;
import com.yourorganization.testtask.feature.book.model.Book;
import com.yourorganization.testtask.feature.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service("bookServiceImpl1")
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }
    @Transactional
    public BookResponseDto createBook(BookRequestDto dto) {
        if (bookRepository.findByIsbn(dto.getIsbn()) != null) {
            throw new InvalidBookDataException("Book with ISBN " + dto.getIsbn() + " already exists.");
        }
        Book book = bookMapper.toEntity(dto);
        book.setCreatedAt(LocalDateTime.now());
        book.setUpdatedAt(LocalDateTime.now());

        Book savedBook = bookRepository.save(book);
        return bookMapper.toDto(savedBook);
    }
    @Transactional
    public BookResponseDto updateBook(UUID id,BookRequestDto dto) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book with id " + id + " not found"));
        if (!book.getIsbn().equals(dto.getIsbn()) && bookRepository.findByIsbn(dto.getIsbn()) != null) {
            throw new InvalidBookDataException("Book with ISBN " + dto.getIsbn() + " already exists.");
        }
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setIsbn(dto.getIsbn());
        book.setUpdatedAt(LocalDateTime.now());
        return bookMapper.toDto(bookRepository.save(book));
    }
    @Transactional(readOnly = true)
    public BookResponseDto findBookById(UUID id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book with id " + id + " not found"));
        return bookMapper.toDto(book);
    }
    @Transactional
    public void deleteBook(UUID id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book with id " + id + " not found"));
        bookRepository.delete(book);
    }
    @Transactional(readOnly = true)
    public Page<BookResponseDto> listBooks(String titleFilter, Pageable pageable) {
        Page<Book> booksPage;
        if (titleFilter != null && !titleFilter.isEmpty()) {
            booksPage = bookRepository.findByTitleContaining(titleFilter, pageable);
        } else {
            booksPage = bookRepository.findAll(pageable);
        }
        return booksPage.map(bookMapper::toDto);
    }
    @Transactional(readOnly = true)
    public BookResponseDto findBookByIsbn(String isbn) {
        Book book = bookRepository.findByIsbn(isbn);
        if (book == null) {
            throw new BookNotFoundException("Book with ISBN " + isbn + " not found");
        }
        return bookMapper.toDto(book);
    }
}
