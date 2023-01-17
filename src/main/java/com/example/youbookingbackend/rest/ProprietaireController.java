package com.example.youbookingbackend.rest;

import com.example.youbookingbackend.entity.Proprietaire;
import com.example.youbookingbackend.entity.User;
import com.example.youbookingbackend.service.ProprietaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/proprietaires")
@CrossOrigin("http://localhost:60435/")
public class ProprietaireController {

    @Autowired
    private ProprietaireService proprietaireService;

    @PostMapping("/add_proprietaire")
    public Proprietaire addProprietaire(@RequestBody Proprietaire proprietaire){
        return proprietaireService.addProprietaire(proprietaire);
    }

    @GetMapping("/AllProprietaires")
    public List<Proprietaire> getAllProprietaires(){
        return proprietaireService.findAllProprietaires();
    }



}
