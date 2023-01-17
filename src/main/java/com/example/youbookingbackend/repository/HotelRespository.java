package com.example.youbookingbackend.repository;

import com.example.youbookingbackend.entity.Chambre;
import com.example.youbookingbackend.entity.Hotel;
import com.example.youbookingbackend.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRespository extends JpaRepository<Hotel,Long> {
    int deleteHotelById(Long id);

    List<Hotel> findAllByStatus(Status status);

    Hotel findHotelByNom(String nom);
}
