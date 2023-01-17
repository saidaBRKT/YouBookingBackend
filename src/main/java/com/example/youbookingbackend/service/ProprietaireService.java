package com.example.youbookingbackend.service;

import com.example.youbookingbackend.entity.Proprietaire;

import java.util.List;

public interface ProprietaireService {

    Proprietaire addProprietaire(Proprietaire proprietaire);
    Proprietaire updateProprietaire(Proprietaire proprietaire);
    Proprietaire DesactiveProprietaire(Long id);
    Proprietaire getProprietaire(Long id);
    List<Proprietaire> findAllProprietaires();

}
