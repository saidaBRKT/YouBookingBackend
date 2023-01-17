package com.example.youbookingbackend.service;

import com.example.youbookingbackend.repository.dto.DateReservationDto;
import com.example.youbookingbackend.repository.dto.ReservationDto;
import com.example.youbookingbackend.repository.dto.ResponseDto;
import com.example.youbookingbackend.entity.Chambre;
import com.example.youbookingbackend.entity.StatusReservation;

import java.util.List;

public interface ReservationService {
    public ResponseDto addReservation(ReservationDto reservationDto);
    public ResponseDto cancelReservation(Long id);
    public ResponseDto updateReservation(ReservationDto reservationDto);
    public List<ReservationDto> findAllReservation();
    public List<ReservationDto> findAllReservationByStatus(StatusReservation status);
    public List<Chambre> findAllReservationByDateDebutAndDateFin(DateReservationDto dateReservationDto);
    public List<Chambre> findAllChambresNotReserved(DateReservationDto dateReservationDto);
}
