package com.example.youbookingbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private  int num;
    private  Double prix;
    private  int nbrLits;
    @Enumerated(EnumType.STRING)
    private  StatusChambre statusChambre;
    @ManyToOne
    private Hotel hotel;
    @OneToMany(mappedBy ="chambre" ,cascade = CascadeType.ALL)
    private List<Reservation> reservationList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public int getNbrLits() {
        return nbrLits;
    }

    public void setNbrLits(int nbrLits) {
        this.nbrLits = nbrLits;
    }

    public StatusChambre getStatusChambre() {
        return statusChambre;
    }

    public void setStatusChambre(StatusChambre statusChambre) {
        this.statusChambre = statusChambre;
    }
    @JsonIgnore
    public Hotel getHotel() {
        return hotel;
    }
    @JsonSetter
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
    @JsonIgnore
    public List<Reservation> getReservationList() {
        return reservationList;
    }
    @JsonSetter
    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }
}
