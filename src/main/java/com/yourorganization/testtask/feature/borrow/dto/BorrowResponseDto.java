package com.yourorganization.testtask.feature.borrow.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class BorrowResponseDto {
    private UUID id;
    private String clientFullName;
    private String bookTitle;
    private LocalDateTime borrowDate;
    private LocalDateTime returnDate;

    public BorrowResponseDto() {
    }

    public BorrowResponseDto(UUID id, String clientFullName, String bookTitle, LocalDateTime borrowDate, LocalDateTime returnDate) {
        this.id = id;
        this.clientFullName = clientFullName;
        this.bookTitle = bookTitle;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }
}
