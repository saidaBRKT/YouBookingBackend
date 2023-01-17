package com.example.youbookingbackend.repository.dto;

import com.example.youbookingbackend.entity.*;
import org.modelmapper.ModelMapper;

public class TransferEntityToDto {
    public static ChambreDto chamberToChamberDto(Chambre chambre) {
        ModelMapper modelMapper=new ModelMapper();
        return modelMapper.map(chambre,ChambreDto.class);
    }

    public static UserDto userToUserDto(User user) {
        ModelMapper modelMapper=new ModelMapper();
        return modelMapper.map(user,UserDto.class);
    }
    public static UserDto clientToUserDto(Client client) {
        ModelMapper modelMapper=new ModelMapper();
        return modelMapper.map(client, UserDto.class);
    }
    public static UserDto PropToUseDto(Proprietaire proprietaire) {
        ModelMapper modelMapper=new ModelMapper();
        return modelMapper.map(proprietaire, UserDto.class);
    }
    public static ReservationDto reservationToReservationDto(Reservation reservation) {
        ModelMapper modelMapper=new ModelMapper();
        return modelMapper.map(reservation,ReservationDto.class);
    }
}
