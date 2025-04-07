package com.yourorganization.testtask.feature.borrow.controller;

import com.yourorganization.testtask.feature.borrow.dto.BorrowRequestDto;
import com.yourorganization.testtask.feature.borrow.dto.BorrowResponseDto;
import com.yourorganization.testtask.feature.borrow.dto.ReadingInfoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BorrowApi {
    BorrowResponseDto borrowBook(BorrowRequestDto borrowRequestDto);
    BorrowResponseDto returnBook(BorrowRequestDto borrowRequestDto);
    Page<BorrowResponseDto> listAllBorrowed(Pageable pageable);
    Page<ReadingInfoDto> getReadingList(Pageable pageable);
}
