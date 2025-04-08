package com.yourorganization.testtask.feature.borrow.repository;

import com.yourorganization.testtask.feature.borrow.model.Borrow;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface BorrowRepository extends JpaRepository<Borrow, UUID> {
    Page<Borrow> findAllByClient_Id(UUID clientId, Pageable pageable);
    Page<Borrow> findAllByBook_Id(UUID bookId, Pageable pageable);
    Borrow findByClient_IdAndBook_IdAndReturnDateIsNull(UUID clientId, UUID bookId);
    @Query(
            value = "SELECT b FROM Borrow b " +
                    "JOIN FETCH b.client " +
                    "JOIN FETCH b.book " +
                    "WHERE b.returnDate IS NULL",
            countQuery = "SELECT COUNT(b) FROM Borrow b WHERE b.returnDate IS NULL"
    )
    Page<Borrow> findAllByReturnDateIsNull(Pageable pageable);
}
