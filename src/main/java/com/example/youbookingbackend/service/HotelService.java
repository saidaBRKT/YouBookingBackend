package com.example.youbookingbackend.service;

import com.example.youbookingbackend.repository.dto.ResponseDto;
import com.example.youbookingbackend.entity.Hotel;

import java.util.List;

public interface HotelService {
    ResponseDto addHotel(Hotel hotel);
    ResponseDto updateHotel(Hotel hotel);
    Hotel getOneHotel(Long idHotel);
    List<Hotel> findAllHotels();
    Hotel desactiveHotel(Long idHotel);
    Hotel approveHotel(Long id);
    List<Hotel> getAllApprovedHotels();

    Hotel getHotelByName(String name);
}
