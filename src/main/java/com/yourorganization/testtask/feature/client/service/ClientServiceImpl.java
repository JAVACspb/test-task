package com.yourorganization.testtask.feature.client.service;

import com.yourorganization.testtask.exeption.type.client.ClientNotFoundException;
import com.yourorganization.testtask.exeption.type.client.InvalidClientDataException;
import com.yourorganization.testtask.feature.client.dto.ClientRequestDto;
import com.yourorganization.testtask.feature.client.dto.ClientResponseDto;
import com.yourorganization.testtask.feature.client.mapper.ClientMapper;
import com.yourorganization.testtask.feature.client.model.Client;
import com.yourorganization.testtask.feature.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public ClientResponseDto createClient(@Valid ClientRequestDto dto) {
        Optional<Client> existing = clientRepository.findByFullNameContaining(dto.getFullName(), Pageable.unpaged())
                .getContent().stream()
                .filter(client -> client.getBirthDate().equals(dto.getBirthDate()))
                .findAny();
        if (existing.isPresent()) {
            throw new InvalidClientDataException("Client with the same full name and birth date already exists.");
        }

        Client client = clientMapper.toEntity(dto);
        Client saved = clientRepository.save(client);
        return clientMapper.toDto(saved);
    }

    @Override
    public ClientResponseDto updateClient(UUID id, @Valid ClientRequestDto dto) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException("Client with id " + id + " not found"));
        client.setFullName(dto.getFullName());
        client.setBirthDate(dto.getBirthDate());
        Client updated = clientRepository.save(client);
        return clientMapper.toDto(updated);
    }

    @Override
    public ClientResponseDto findClientById(UUID id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException("Client with id " + id + " not found"));
        return clientMapper.toDto(client);
    }

    @Override
    public void deleteClient(UUID id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException("Client with id " + id + " not found"));
        clientRepository.delete(client);
    }

    @Override
    public Page<ClientResponseDto> listClients(String fullNameFilter, Pageable pageable) {
        Page<Client> clients;
        if (fullNameFilter != null && !fullNameFilter.isEmpty()) {
            clients = clientRepository.findByFullNameContaining(fullNameFilter, pageable);
        } else {
            clients = clientRepository.findAll(pageable);
        }
        return clients.map(clientMapper::toDto);
    }
}
