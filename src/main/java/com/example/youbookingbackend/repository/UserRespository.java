package com.example.youbookingbackend.repository;

import com.example.youbookingbackend.entity.Chambre;
import com.example.youbookingbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespository extends JpaRepository<User,Long> {
    int deleteUserById(Long id);
    User getUserByEmail(String email);
}
