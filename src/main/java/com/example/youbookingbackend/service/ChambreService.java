package com.example.youbookingbackend.service;

import com.example.youbookingbackend.repository.dto.ChambreDto;
import com.example.youbookingbackend.repository.dto.ResponseDto;
import com.example.youbookingbackend.entity.StatusChambre;

import java.util.List;

public interface ChambreService {
    ResponseDto updateChambre(ChambreDto chambreDto);

    ResponseDto addChambre(ChambreDto chambreDto);

    List<ChambreDto> findAllChambre();

    List<ChambreDto> findAllChambreByStatus(StatusChambre statusChambre);
    List<ChambreDto> findAllChambreHotel(Long idHotel);
    ResponseDto deleteChambre(int num);

}
