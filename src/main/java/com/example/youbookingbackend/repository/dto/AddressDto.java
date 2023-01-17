package com.example.youbookingbackend.repository.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
    private Long id;
    private String ville;
    private String pays;
    private String codePostal;
    private String address;
}
