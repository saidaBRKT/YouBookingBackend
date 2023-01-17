package com.example.youbookingbackend.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    private Client client;
    @ManyToOne
    private Chambre chambre;
    @Enumerated(EnumType.STRING)
    private StatusReservation statusReservation;
    private LocalDate dateDebut;
    private LocalDate dateFin;

}
