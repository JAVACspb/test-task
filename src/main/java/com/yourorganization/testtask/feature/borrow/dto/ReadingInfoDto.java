package com.yourorganization.testtask.feature.borrow.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class ReadingInfoDto {
    private String clientFullName;
    private LocalDate clientBirthDate;
    private String bookTitle;
    private String bookAuthor;
    private String bookIsbn;
    private LocalDate borrowDate;

    public ReadingInfoDto() {
    }

    public ReadingInfoDto(String clientFullName, LocalDate clientBirthDate, String bookTitle, String bookAuthor, String bookIsbn, LocalDate borrowDate) {
        this.clientFullName = clientFullName;
        this.clientBirthDate = clientBirthDate;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookIsbn = bookIsbn;
        this.borrowDate = borrowDate;
    }
}
