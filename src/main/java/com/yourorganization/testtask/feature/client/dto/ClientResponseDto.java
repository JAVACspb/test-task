package com.yourorganization.testtask.feature.client.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class ClientResponseDto {
    private UUID id;
    private String fullName;
    private LocalDate birthDate;

    public ClientResponseDto() {
    }

    public ClientResponseDto(UUID id, String fullName, LocalDate birthDate) {
        this.id = id;
        this.fullName = fullName;
        this.birthDate = birthDate;
    }

}
