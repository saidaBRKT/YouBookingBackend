package com.example.youbookingbackend.repository.dto;

import com.example.youbookingbackend.entity.Status;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {
    private Long id;
    private String nom;
    private String tel;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Status status;
    private AddressDto address;
    private RoleDto role;

    public UserDto(String nom, String tel, String email,String password, Status status, AddressDto address, RoleDto role) {
        this.nom = nom;
        this.email = email;
        this.password = password;
        this.status=status;
        this.tel = tel;
        this.address = address;
        this.role = role;

    }
}
