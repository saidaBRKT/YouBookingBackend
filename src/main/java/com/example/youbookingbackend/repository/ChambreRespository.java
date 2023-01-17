package com.example.youbookingbackend.repository;

import com.example.youbookingbackend.entity.Chambre;
import com.example.youbookingbackend.entity.StatusChambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChambreRespository extends JpaRepository<Chambre,Long> {
    int deleteByNum(int num);
    Chambre getByNum(int num);

    public List<Chambre> findAllByStatusChambre(StatusChambre statusChambre);

    public List<Chambre> findAllByReservationListNull();

    @Query("select c from  Chambre c where c.hotel.id=:idHotel")
    public List<Chambre>  findChambreByHotel(Long idHotel);


}
