package com.example.youbookingbackend.service.Imp;

import com.example.youbookingbackend.entity.Client;
import com.example.youbookingbackend.entity.Proprietaire;
import com.example.youbookingbackend.entity.Status;
import com.example.youbookingbackend.entity.User;
import com.example.youbookingbackend.repository.ClientRespository;
import com.example.youbookingbackend.repository.ProprietaireRespository;
import com.example.youbookingbackend.service.ClientService;
import com.example.youbookingbackend.service.ProprietaireService;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProprietaireServiceImp implements ProprietaireService {
    @Autowired
    private ProprietaireRespository proprietaireRespository;

    @Override
    public Proprietaire addProprietaire(Proprietaire proprietaire) {
        if(proprietaire == null || proprietaire == new User()){
            throw new IllegalStateException("Tout les données sont obligatoire");
        }else if (proprietaireRespository.getProprietaireByEmail(proprietaire.getEmail())!=null) {
            throw new IllegalStateException("Le roprietaire existe deja");
        }else{
            return proprietaireRespository.save(proprietaire);
        }
    }

    @Override
    public Proprietaire updateProprietaire(Proprietaire proprietaire) {
        Proprietaire proprietaireToUpdate=proprietaireRespository.findById(proprietaire.getId()).get();
        if(proprietaireToUpdate == null)
            throw new IllegalStateException("Tout les données sont obligatoire");
        else{
            proprietaireToUpdate=proprietaire;
            return proprietaireRespository.save(proprietaireToUpdate);
        }
    }

    @Override
    public Proprietaire DesactiveProprietaire(Long id) {
        Proprietaire proprietaire=proprietaireRespository.findById(id).get();
        if(proprietaire!=null)
            throw new IllegalStateException("Le client n'existe pas");
        else{
            proprietaire.setStatus(Status.Desactive);
            return proprietaire;
        }
    }

    @Override
    public Proprietaire getProprietaire(Long id) {
        Proprietaire proprietaire=proprietaireRespository.findById(id).get();
        if(proprietaire == null)
            throw new IllegalStateException("le client n'existe pas");
        else{
            return proprietaire;
        }
    }

    @Override
    public List<Proprietaire> findAllProprietaires() {
        return proprietaireRespository.findAll();
    }
}
