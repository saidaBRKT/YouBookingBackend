package com.example.youbookingbackend.repository;

import com.example.youbookingbackend.entity.Address;
import com.example.youbookingbackend.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRespository extends JpaRepository<Role,Long> {

}
