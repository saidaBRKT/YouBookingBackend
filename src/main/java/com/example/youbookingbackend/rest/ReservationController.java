package com.example.youbookingbackend.rest;

import com.example.youbookingbackend.repository.dto.DateReservationDto;
import com.example.youbookingbackend.repository.dto.ReservationDto;
import com.example.youbookingbackend.repository.dto.ResponseDto;
import com.example.youbookingbackend.entity.Chambre;
import com.example.youbookingbackend.entity.StatusReservation;
import com.example.youbookingbackend.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Reservations")
@CrossOrigin("http://localhost:60435/")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/addReservation")
    public ResponseDto addReservation(@RequestBody ReservationDto reservationDto){
        return reservationService.addReservation(reservationDto);
    }

    @PutMapping("/updateReservation")
    public ResponseDto updateReservation(@RequestBody ReservationDto reservationDto){
        return reservationService.updateReservation(reservationDto);
    }

    @PutMapping("/cancelReservation/id/{id}")
    public ResponseDto cancelReservation(@PathVariable Long id){
        return reservationService.cancelReservation(id);
    }

    @GetMapping("/AllReservations")
    public List<ReservationDto> getAllReservations(){
        return reservationService.findAllReservation();
    }

    @GetMapping("/AllReservations/Status/{status}")
    public List<ReservationDto> getAllReservations(@PathVariable StatusReservation statusReservation){
        return reservationService.findAllReservationByStatus(statusReservation);
    }

    @GetMapping("/AllByDateDebutAndDateFin")
    public List<Chambre> getAllReservationsByDateDebutAndDateFin(@RequestBody DateReservationDto dateReservationDto){
        return reservationService.findAllReservationByDateDebutAndDateFin(dateReservationDto);
    }

    @PostMapping("/AllChambresNotReserved")
    public List<Chambre> getAllChambersNotReserved(@RequestBody DateReservationDto dateReservationDto){
        System.out.println(dateReservationDto.getDateDebut());
        return reservationService.findAllChambresNotReserved(dateReservationDto);
    }


}
