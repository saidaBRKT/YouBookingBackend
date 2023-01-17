package com.example.youbookingbackend.repository;

import com.example.youbookingbackend.entity.Client;
import com.example.youbookingbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRespository extends JpaRepository<Client,Long> {
    int deleteClientById(Long id);
    User getClientByEmail(String email);
}
