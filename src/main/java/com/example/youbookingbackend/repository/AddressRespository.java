package com.example.youbookingbackend.repository;

import com.example.youbookingbackend.entity.Address;
import com.example.youbookingbackend.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRespository extends JpaRepository<Address,Long> {
    int deleteAddressById(Long id);
}
