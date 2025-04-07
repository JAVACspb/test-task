package com.yourorganization.testtask.feature.client.service;


import com.yourorganization.testtask.feature.client.dto.ClientRequestDto;
import com.yourorganization.testtask.feature.client.dto.ClientResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ClientService {
    ClientResponseDto createClient(ClientRequestDto dto);
    ClientResponseDto updateClient(UUID id, ClientRequestDto dto);
    ClientResponseDto findClientById(UUID id);
    void deleteClient(UUID id);
    Page<ClientResponseDto> listClients(String fullNameFilter, Pageable pageable);
}
