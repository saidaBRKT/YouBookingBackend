package com.example.youbookingbackend.repository.dto;

import com.example.youbookingbackend.entity.*;
import org.modelmapper.ModelMapper;

public class TransferDtoToEntity {
    public static Chambre chamberDtoToChamber(ChambreDto chambreDto) {
        ModelMapper modelMapper=new ModelMapper();
        return modelMapper.map(chambreDto,Chambre.class);
    }

    public static User userDtoToUser(UserDto userDto) {
        ModelMapper modelMapper=new ModelMapper();
        return modelMapper.map(userDto,User.class);
    }

    public static Client userDtoToClient(UserDto userDto) {
        ModelMapper modelMapper=new ModelMapper();
        return modelMapper.map(userDto, Client.class);
    }
    public static Proprietaire userDtoToProp(UserDto userDto) {
        ModelMapper modelMapper=new ModelMapper();
        return modelMapper.map(userDto, Proprietaire.class);
    }

    public static Reservation reservationDtoToReservation(ReservationDto reservationDto) {
        ModelMapper modelMapper=new ModelMapper();
        return modelMapper.map(reservationDto,Reservation.class);
    }


}
