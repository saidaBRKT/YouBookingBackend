package com.example.youbookingbackend.repository.dto;

import com.example.youbookingbackend.entity.Chambre;
import com.example.youbookingbackend.entity.Client;
import com.example.youbookingbackend.entity.StatusReservation;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto {
    private Long id;
    private Client client;
    private Chambre chambre;
    @Enumerated(EnumType.STRING)
    private StatusReservation statusReservation;
    private LocalDate dateDebut;
    private LocalDate dateFin;
}
