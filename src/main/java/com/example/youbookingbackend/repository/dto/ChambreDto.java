package com.example.youbookingbackend.repository.dto;

import com.example.youbookingbackend.entity.Hotel;
import com.example.youbookingbackend.entity.StatusChambre;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChambreDto {
    private Long id;
    private  int num;
    private  Double prix;
    private  int nbrLits;
    @Enumerated(EnumType.STRING)
    private StatusChambre statusChambre;
    private Hotel hotel;
}
