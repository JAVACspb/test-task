package com.yourorganization.testtask.feature.client.controller;

import com.yourorganization.testtask.feature.client.dto.ClientRequestDto;
import com.yourorganization.testtask.feature.client.dto.ClientResponseDto;
import com.yourorganization.testtask.feature.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/v2/")
public class ClientController implements ClientApi {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/create")
    public ClientResponseDto createClient(@RequestBody @Valid ClientRequestDto clientRequestDto) {
        return clientService.createClient(clientRequestDto);
    }

    @PutMapping("/update/{id}")
    public ClientResponseDto updateClient(@PathVariable UUID id, @RequestBody @Valid ClientRequestDto clientRequestDto) {
        return clientService.updateClient(id, clientRequestDto);
    }

    @GetMapping("/getBy/{id}")
    public ClientResponseDto getClientById(@PathVariable UUID id) {
        return clientService.findClientById(id);
    }

    @DeleteMapping("/deleteBy/{id}")
    public void deleteClient(@PathVariable UUID id) {
        clientService.deleteClient(id);
    }

    @GetMapping("/getAll")
    public Page<ClientResponseDto> getAllClients(Pageable pageable, @RequestParam(required = false) String fullName) {
        return clientService.listClients(fullName, pageable);
    }
}
