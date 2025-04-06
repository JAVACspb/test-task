package com.yourorganization.testtask.feature.book.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;
@Getter
@Setter
public class BookResponseDto {
    private UUID id;
    private String title;
    private String author;
    private String isbn;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public BookResponseDto() {
    }

    public BookResponseDto(UUID id, String title, String author, String isbn, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}
