package com.yourorganization.testtask.feature.borrow.service;

import com.yourorganization.testtask.feature.borrow.dto.BorrowRequestDto;
import com.yourorganization.testtask.feature.borrow.dto.BorrowResponseDto;
import com.yourorganization.testtask.feature.borrow.dto.ReadingInfoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BorrowService {
    BorrowResponseDto borrowBook(BorrowRequestDto dto);
    BorrowResponseDto returnBook(BorrowRequestDto dto);
    Page<BorrowResponseDto> listAllBorrowed(Pageable pageable);
    Page<ReadingInfoDto> getAllReadingClients(Pageable pageable);
}
