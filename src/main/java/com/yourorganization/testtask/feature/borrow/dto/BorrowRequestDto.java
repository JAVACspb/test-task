package com.yourorganization.testtask.feature.borrow.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
public class BorrowRequestDto {
    @NotNull(message = "Client ID is mandatory")
    private UUID clientId;

    @NotNull(message = "Book ID is mandatory")
    private UUID bookId;

    public BorrowRequestDto() {
    }

    public BorrowRequestDto(UUID clientId, UUID bookId) {
        this.clientId = clientId;
        this.bookId = bookId;
    }
}
