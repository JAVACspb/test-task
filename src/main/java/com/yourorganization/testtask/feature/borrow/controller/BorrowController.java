package com.yourorganization.testtask.feature.borrow.controller;


import com.yourorganization.testtask.feature.borrow.dto.BorrowRequestDto;
import com.yourorganization.testtask.feature.borrow.dto.BorrowResponseDto;
import com.yourorganization.testtask.feature.borrow.dto.ReadingInfoDto;
import com.yourorganization.testtask.feature.borrow.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v3/")
public class BorrowController implements BorrowApi {

    private final BorrowService borrowService;

    @Autowired
    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    // Выдать книгу клиенту
    @PostMapping("/borrow")
    public BorrowResponseDto borrowBook(@RequestBody @Valid BorrowRequestDto borrowRequestDto) {
        return borrowService.borrowBook(borrowRequestDto);
    }

    // Вернуть книгу
    @PostMapping("/return")
    public BorrowResponseDto returnBook(@RequestBody @Valid BorrowRequestDto borrowRequestDto) {
        return borrowService.returnBook(borrowRequestDto);
    }

    // Получить список всех активных выдач (где returnDate is null)
    @GetMapping("/All_borrowed")
    public Page<BorrowResponseDto> listAllBorrowed(Pageable pageable) {
        return borrowService.listAllBorrowed(pageable);
    }
    @GetMapping("/reading-list")
    public Page<ReadingInfoDto> getReadingList(Pageable pageable) {
        return borrowService.getAllReadingClients(pageable);
    }
}
