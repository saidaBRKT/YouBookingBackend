package com.example.youbookingbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import java.util.List;

@Entity
public class Client extends User {
    @OneToMany(mappedBy ="client" ,cascade = CascadeType.ALL)
    private List<Reservation> reservationList;

    @JsonIgnore
    public List<Reservation> getReservationList() {
        return reservationList;
    }

    @JsonSetter
    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }
}
