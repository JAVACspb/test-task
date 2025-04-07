package com.yourorganization.testtask.feature.client.controller;

import com.yourorganization.testtask.feature.client.dto.ClientRequestDto;
import com.yourorganization.testtask.feature.client.dto.ClientResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ClientApi {
    ClientResponseDto createClient(ClientRequestDto clientRequestDto);
    ClientResponseDto updateClient(UUID id, ClientRequestDto clientRequestDto);
    ClientResponseDto getClientById(UUID id);
    void deleteClient(UUID id);
    Page<ClientResponseDto> getAllClients(Pageable pageable, String fullName);
}
