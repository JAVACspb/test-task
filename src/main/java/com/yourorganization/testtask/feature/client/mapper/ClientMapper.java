package com.yourorganization.testtask.feature.client.mapper;

import com.yourorganization.testtask.feature.client.dto.ClientRequestDto;
import com.yourorganization.testtask.feature.client.dto.ClientResponseDto;
import com.yourorganization.testtask.feature.client.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    Client toEntity(ClientRequestDto dto);

    ClientResponseDto toDto(Client client);
}
