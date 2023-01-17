package com.example.youbookingbackend.rest;

import com.example.youbookingbackend.repository.dto.ResponseDto;
import com.example.youbookingbackend.entity.Hotel;
import com.example.youbookingbackend.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/v1/hotels")
@CrossOrigin("http://localhost:60435/")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @PostMapping("/add_hotel")
    public ResponseDto addHotel(@RequestBody Hotel hotel){
        return hotelService.addHotel(hotel);
    }

    @PutMapping("/update_hotel")
    public ResponseDto updateHotel(@RequestBody Hotel hotel){
        return hotelService.updateHotel(hotel);
    }

    @GetMapping("/AllHotels")
    public List<Hotel> getAllHotels(){
        return hotelService.findAllHotels();
    }

    @GetMapping("/OneHotel/id/{id}")
    public Hotel getOneHotel(@PathVariable Long id){
        return hotelService.getOneHotel(id);
    }

    @GetMapping("/AllApprovedHotels")
    public List<Hotel> getAllApprovedHotels(){
        return hotelService.getAllApprovedHotels();
    }

    @PutMapping("/desactive/id/{id}")
    public Hotel desactiveHotel(@PathVariable Long id){
        return hotelService.desactiveHotel(id);
    }

    @PutMapping("/active/id/{id}")
    public Hotel activeHotel(@PathVariable Long id){
        return hotelService.approveHotel(id);
    }

    @GetMapping("/getOneHotelByName/name/{name}")
    public Hotel getHotelByName(@PathVariable String name){
        return hotelService.getHotelByName(name);
    }

}
