package com.example.youbookingbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;
@Entity

public class Proprietaire extends User {

    @OneToMany(mappedBy ="proprietaire" ,cascade = CascadeType.ALL)
    private List<Hotel> hotels;

    @JsonIgnore
    public List<Hotel> getHotels() {
        return hotels;
    }
    @JsonSetter
    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }
}
