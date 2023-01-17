package com.example.youbookingbackend.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nom;
    private String tel;
    @OneToOne
    private Address adresse;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    private Proprietaire proprietaire;
    @OneToMany(mappedBy ="hotel" ,cascade = CascadeType.ALL)
    private List<Chambre> chambreList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Address getAdresse() {
        return adresse;
    }

    public void setAdresse(Address adresse) {
        this.adresse = adresse;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @JsonIgnore
    public Proprietaire getProprietaire() {
        return proprietaire;
    }
    @JsonSetter
    public void setProprietaire(Proprietaire proprietaire) {
        this.proprietaire = proprietaire;
    }

    public List<Chambre> getChambreList() {
        return chambreList;
    }

    public void setChambreList(List<Chambre> chambreList) {
        this.chambreList = chambreList;
    }
}
