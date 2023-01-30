package com.example.youbookingbackend.service.Imp;

import com.example.youbookingbackend.entity.Chambre;
import com.example.youbookingbackend.entity.Reservation;
import com.example.youbookingbackend.entity.StatusReservation;
import com.example.youbookingbackend.repository.ReservationRespository;
import com.example.youbookingbackend.repository.dto.*;
import com.example.youbookingbackend.service.ReservationService;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ReservationServiceImp implements ReservationService {
    @Autowired
    private ReservationRespository reservationRespository;
    @Override
    public ResponseDto addReservation(ReservationDto reservationDto) {
        Reservation reservation= TransferDtoToEntity.reservationDtoToReservation(reservationDto);
        if(reservation.getChambre()==null || reservation.getClient()==null || reservation.getDateDebut()==null || reservation.getDateFin()==null){
            return new ResponseDto("Bad request","Toutes les données sont obligatoires");

        }
        else {
            Reservation reservation1=reservationRespository.save(reservation);
            return new ResponseDto("success","Updateded succefuly", TransferEntityToDto.reservationToReservationDto(reservation1));

        }
    }

    @Override
    public ResponseDto cancelReservation(Long id) {
        Reservation reservation=reservationRespository.findById(id).get();
        if(reservation==null)
            throw new IllegalStateException("La reservation n'existe pas");
        else{
            reservation.setStatusReservation(StatusReservation.Canceled);
           // return reservationRespository.save(reservation);
            Reservation reservation1=reservationRespository.save(reservation);
            return new ResponseDto("success","Updateded succefuly", TransferEntityToDto.reservationToReservationDto(reservation1));

        }
    }

    @Override
    public ResponseDto updateReservation(ReservationDto reservationDto) {
        Reservation reservation=TransferDtoToEntity.reservationDtoToReservation(reservationDto);
        Reservation reservationToUpdate=reservationRespository.findById(reservation.getId()).get();
        if(reservationToUpdate == null)
            throw new IllegalStateException("Tout les données sont obligatoire");
        else{
            reservationToUpdate=reservation;
          //  return reservationRespository.save(reservationToUpdate);
            Reservation reservation1=reservationRespository.save(reservationToUpdate);
            return new ResponseDto("success","Updated successfuly",TransferEntityToDto.reservationToReservationDto(reservation1));
        }
    }

    @Override
    public List<ReservationDto> findAllReservation() {
        return reservationRespository.findAll().stream().map(reservation -> TransferEntityToDto.reservationToReservationDto(reservation)).collect(Collectors.toList());

    }

    @Override
    public List<ReservationDto> findAllReservationByStatus(StatusReservation status) {
        return reservationRespository.findAllByStatusReservation(status).stream().map(reservation -> TransferEntityToDto.reservationToReservationDto(reservation)).collect(Collectors.toList());
    }

    @Override
    public List<Chambre> findAllReservationByDateDebutAndDateFin(DateReservationDto dateReservationDto) {
        return reservationRespository.findAllByDateDebutAndDateFin(dateReservationDto.getDateDebut(),dateReservationDto.getDateFin());
    }

    @Override
    public List<Chambre> findAllChambresNotReserved(DateReservationDto dateReservationDto) {
        return reservationRespository.findAllChamberNotRserved(dateReservationDto.getDateDebut(),dateReservationDto.getDateFin());
    }

}
