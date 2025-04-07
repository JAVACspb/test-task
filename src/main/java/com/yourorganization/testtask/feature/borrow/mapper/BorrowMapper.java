package com.yourorganization.testtask.feature.borrow.mapper;

import com.yourorganization.testtask.feature.borrow.dto.BorrowResponseDto;
import com.yourorganization.testtask.feature.borrow.dto.ReadingInfoDto;
import com.yourorganization.testtask.feature.borrow.model.Borrow;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BorrowMapper {

    @Mapping(source = "client.fullName", target = "clientFullName")
    @Mapping(source = "book.title", target = "bookTitle")
    BorrowResponseDto toDto(Borrow borrow);

    // Маппинг для "читающих клиентов"
    @Mapping(source = "client.fullName", target = "clientFullName")
    @Mapping(source = "client.birthDate", target = "clientBirthDate")
    @Mapping(source = "book.title", target = "bookTitle")
    @Mapping(source = "book.author", target = "bookAuthor")
    @Mapping(source = "book.isbn", target = "bookIsbn")
    @Mapping(source = "borrowDate", target = "borrowDate")
    ReadingInfoDto toReadingInfoDto(Borrow borrow);
}

