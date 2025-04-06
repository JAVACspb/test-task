package com.yourorganization.testtask.feature.book.mapper;

import com.yourorganization.testtask.feature.book.dto.BookRequestDto;
import com.yourorganization.testtask.feature.book.dto.BookResponseDto;
import com.yourorganization.testtask.feature.book.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Book toEntity(BookRequestDto dto);

    BookResponseDto toDto(Book entity);
}
