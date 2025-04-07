package com.yourorganization.testtask.feature.client.repository;

import com.yourorganization.testtask.feature.client.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
    Page<Client> findByFullNameContaining(String fullName, Pageable pageable);
}
