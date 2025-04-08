package com.yourorganization.testtask.feature.borrow.controller;


import com.yourorganization.testtask.feature.borrow.dto.BorrowRequestDto;
import com.yourorganization.testtask.feature.borrow.dto.BorrowResponseDto;
import com.yourorganization.testtask.feature.borrow.dto.ReadingInfoDto;
import com.yourorganization.testtask.feature.borrow.service.BorrowService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/borrow")
@Tag(name = "Borrow", description = "Операции с заказами")
public class BorrowController implements BorrowApi {

    private final BorrowService borrowService;

    @Autowired
    public BorrowController(@Qualifier("borrowServiceImpl1") BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    @PostMapping("/borrow")
    public BorrowResponseDto borrowBook(@RequestBody @Valid BorrowRequestDto borrowRequestDto) {
        return borrowService.borrowBook(borrowRequestDto);
    }

    @PostMapping("/return")
    public BorrowResponseDto returnBook(@RequestBody @Valid BorrowRequestDto borrowRequestDto) {
        return borrowService.returnBook(borrowRequestDto);
    }

    @GetMapping("/all_borrowed")
    public Page<BorrowResponseDto> listAllBorrowed(Pageable pageable) {
        return borrowService.listAllBorrowed(pageable);
    }

    @GetMapping("/reading_list")
    public Page<ReadingInfoDto> getReadingList(Pageable pageable) {
        return borrowService.getAllReadingClients(pageable);
    }

}
