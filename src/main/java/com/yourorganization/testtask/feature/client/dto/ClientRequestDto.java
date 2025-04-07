package com.yourorganization.testtask.feature.client.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
public class ClientRequestDto {
    @NotBlank(message = "Full name is mandatory")
    @Size(min = 1, max = 255, message = "Full name must be between 1 and 255 characters")
    private String fullName;

    @NotNull(message = "Birth date is mandatory")
    @Past(message = "Birth date must be in the past")
    private LocalDate birthDate;

    public ClientRequestDto() {
    }

    public ClientRequestDto(String fullName, LocalDate birthDate) {
        this.fullName = fullName;
        this.birthDate = birthDate;
    }
}
