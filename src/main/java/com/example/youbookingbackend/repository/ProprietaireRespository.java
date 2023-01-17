package com.example.youbookingbackend.repository;

import com.example.youbookingbackend.entity.Proprietaire;
import com.example.youbookingbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProprietaireRespository extends JpaRepository<Proprietaire,Long> {
    int deleteProprietaireById(Long id);
    User getProprietaireByEmail(String email);

}
