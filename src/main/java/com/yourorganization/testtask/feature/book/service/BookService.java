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

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Autowired
    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    /**
     * Создать новую книгу.
     */
    public BookResponseDto createBook(@Valid BookRequestDto dto) {
        // Проверка на уникальность ISBN (можно добавить более сложную логику)
        if (bookRepository.findByIsbn(dto.getIsbn()) != null) {
            throw new InvalidBookDataException("Book with ISBN " + dto.getIsbn() + " already exists.");
        }

        Book book = bookMapper.toEntity(dto);
        book.setCreatedAt(LocalDateTime.now());
        book.setUpdateAt(LocalDateTime.now());

        Book savedBook = bookRepository.save(book);
        return bookMapper.toDto(savedBook);
    }

    /**
     * Обновить книгу по UUID.
     */
    public BookResponseDto updateBook(UUID id, @Valid BookRequestDto dto) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book with id " + id + " not found"));
        if (!book.getIsbn().equals(dto.getIsbn()) && bookRepository.findByIsbn(dto.getIsbn()) != null) {
            throw new InvalidBookDataException("Book with ISBN " + dto.getIsbn() + " already exists.");
        }
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setIsbn(dto.getIsbn());
        book.setUpdateAt(LocalDateTime.now());
        return bookMapper.toDto(bookRepository.save(book));
    }

    public BookResponseDto findBookById(UUID id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book with id " + id + " not found"));
        return bookMapper.toDto(book);
    }

    public void deleteBook(UUID id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book with id " + id + " not found"));
        bookRepository.delete(book);
    }

    public Page<BookResponseDto> listBooks(String titleFilter, Pageable pageable) {
        Page<Book> booksPage;
        if (titleFilter != null && !titleFilter.isEmpty()) {
            booksPage = bookRepository.findByTitleContaining(titleFilter, pageable);
        } else {
            booksPage = bookRepository.findAll(pageable);
        }
        return booksPage.map(bookMapper::toDto);
    }

    public BookResponseDto findBookByIsbn(String isbn) {
        Book book = bookRepository.findByIsbn(isbn);
        if (book == null) {
            throw new BookNotFoundException("Book with ISBN " + isbn + " not found");
        }
        return bookMapper.toDto(book);
    }
}
