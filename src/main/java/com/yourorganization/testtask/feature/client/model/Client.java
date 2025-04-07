package com.yourorganization.testtask.feature.client.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Client {

    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @NotBlank(message = "Full name is mandatory")
    @Size(min = 1, max = 255, message = "Full name must be between 1 and 255 characters")
    @Column(name = "full_name", nullable = false)
    private String fullName;

    @NotNull(message = "Birth date is mandatory")
    @Past(message = "Birth date must be in the past")
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    public Client() {
    }

    public Client(UUID id, String fullName, LocalDate birthDate) {
        this.id = id;
        this.fullName = fullName;
        this.birthDate = birthDate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id != null && id.equals(client.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
