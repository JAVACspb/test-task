package com.yourorganization.testtask.feature.borrow.service;

import com.yourorganization.testtask.exeption.type.borrow.BorrowNotFoundException;
import com.yourorganization.testtask.feature.book.model.Book;
import com.yourorganization.testtask.feature.book.repository.BookRepository;
import com.yourorganization.testtask.feature.borrow.dto.BorrowRequestDto;
import com.yourorganization.testtask.feature.borrow.dto.BorrowResponseDto;
import com.yourorganization.testtask.feature.borrow.dto.ReadingInfoDto;
import com.yourorganization.testtask.feature.borrow.mapper.BorrowMapper;
import com.yourorganization.testtask.feature.borrow.model.Borrow;
import com.yourorganization.testtask.feature.borrow.repository.BorrowRepository;
import com.yourorganization.testtask.feature.client.model.Client;
import com.yourorganization.testtask.feature.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowServiceImpl implements BorrowService {

    private final BorrowRepository borrowRepository;
    private final BorrowMapper borrowMapper;
    private final ClientRepository clientRepository;
    private final BookRepository bookRepository;

    @Autowired
    public BorrowServiceImpl(BorrowRepository borrowRepository, BorrowMapper borrowMapper,
                             ClientRepository clientRepository, BookRepository bookRepository) {
        this.borrowRepository = borrowRepository;
        this.borrowMapper = borrowMapper;
        this.clientRepository = clientRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    @Transactional
    public BorrowResponseDto borrowBook(@Valid BorrowRequestDto dto) {
        Client client = clientRepository.findById(dto.getClientId())
                .orElseThrow(() -> new BorrowNotFoundException("Client not found with id " + dto.getClientId()));
        Book book = bookRepository.findById(dto.getBookId())
                .orElseThrow(() -> new BorrowNotFoundException("Book not found with id " + dto.getBookId()));
        Borrow existing = borrowRepository.findByClient_IdAndBook_IdAndReturnDateIsNull(dto.getClientId(), dto.getBookId());
        if (existing != null) {
            throw new BorrowNotFoundException("This book is already borrowed by the client");
        }

        Borrow borrow = new Borrow();
        borrow.setClient(client);
        borrow.setBook(book);
        borrow.setBorrowDate(LocalDateTime.now());

        Borrow saved = borrowRepository.save(borrow);
        return borrowMapper.toDto(saved);
    }

    @Override
    @Transactional
    public BorrowResponseDto returnBook(@Valid BorrowRequestDto dto) {
        Borrow borrow = borrowRepository.findByClient_IdAndBook_IdAndReturnDateIsNull(dto.getClientId(), dto.getBookId());
        if (borrow == null) {
            throw new BorrowNotFoundException("No active borrow found for client and book");
        }

        borrow.setReturnDate(LocalDateTime.now());
        Borrow updated = borrowRepository.save(borrow);
        return borrowMapper.toDto(updated);
    }
    public Page<ReadingInfoDto> getAllReadingClients(Pageable pageable) {
        Page<Borrow> page = borrowRepository.findAllByReturnDateIsNull(pageable);

        List<ReadingInfoDto> dtoList = page.getContent().stream()
                .map(borrowMapper::toReadingInfoDto)
                .collect(Collectors.toList());

        return new PageImpl<>(dtoList, pageable, page.getTotalElements());
    }

    @Override
    public Page<BorrowResponseDto> listAllBorrowed(Pageable pageable) {
        return borrowRepository.findAllByReturnDateIsNull(pageable)
                .map(borrowMapper::toDto);
    }
}
