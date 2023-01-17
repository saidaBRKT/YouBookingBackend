package com.example.youbookingbackend.service.Imp;

import com.example.youbookingbackend.repository.dto.TransferDtoToEntity;
import com.example.youbookingbackend.repository.dto.TransferEntityToDto;
import com.example.youbookingbackend.repository.dto.UserDto;
import com.example.youbookingbackend.entity.*;
import com.example.youbookingbackend.repository.AddressRespository;
import com.example.youbookingbackend.repository.RoleRespository;
import com.example.youbookingbackend.repository.UserRespository;
import com.example.youbookingbackend.service.ClientService;
import com.example.youbookingbackend.service.ProprietaireService;
import com.example.youbookingbackend.service.UserService;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {
    @Autowired
    private UserRespository userRespository;

    @Autowired
    private ClientService clientService;

    @Autowired
    private ProprietaireService proprietaireService;

    @Autowired
    RoleRespository roleRespository;

    @Autowired
    AddressRespository addressRespository;

    @Override
    public UserDto addUser(UserDto userDto) {
        User user= TransferDtoToEntity.userDtoToUser(userDto);
        Role role=roleRespository.findById(userDto.getRole().getId()).get();
        Address address=user.getAddress();

        if(user == null || user == new User()){
            throw new IllegalStateException("Tout les données sont obligatoire");
        }else if (userRespository.getUserByEmail(user.getEmail())!=null) {
            throw new IllegalStateException("L'utilisateur existe deja");
        }else{
            UserDto userDto1=new UserDto();
            if(role.getName().equals("Client")){
                addressRespository.save(address);
                userDto.setStatus(Status.Active);
                Client client= clientService.addClient(TransferDtoToEntity.userDtoToClient(userDto));
                userDto1=TransferEntityToDto.clientToUserDto(client);
            }else if(role.getName().equals("Proprietaire")){
                addressRespository.save(address);
                userDto.setStatus(Status.Desactive);
                Proprietaire proprietaire= proprietaireService.addProprietaire(TransferDtoToEntity.userDtoToProp(userDto));
                userDto1=TransferEntityToDto.PropToUseDto(proprietaire);
            }
            return userDto1;
        }
    }

    @Override
    public User DesactiveUser(Long id) {
        User user=userRespository.findById(id).get();
        if(user!=null)
            throw new IllegalStateException("L'utilisateur n'existe pas");
        else{
            if(user.getRole().getName()== "Client"){
                Client client=clientService.getClient(user.getId());
                client.setStatus(Status.Desactive);
                clientService.updateClient(client);
            }else if(user.getRole().getName()== "Proprietaire"){
                Proprietaire proprietaire= proprietaireService.getProprietaire(user.getId());
                proprietaire.setStatus(Status.Desactive);
                proprietaireService.updateProprietaire(proprietaire);
            }
            user.setStatus(Status.Desactive);
            return user;
        }
    }

    @Override
    public User updateUser(User user) {
        User userToUpdated=userRespository.findById(user.getId()).get();
        if(userToUpdated == null)
            throw new IllegalStateException("Tout les données sont obligatoire");
        else{
            userToUpdated=user;
            if(user.getRole().getName()== "Client"){
                clientService.updateClient((Client)userToUpdated);
            }else if(user.getRole().getName()== "Proprietaire"){
                proprietaireService.updateProprietaire((Proprietaire)userToUpdated);
            }
            return userRespository.save(userToUpdated);
        }
    }

    @Override
    public User getUser(Long idUser) {
        User user=userRespository.findById(idUser).get();
        if(user == null)
            throw new IllegalStateException("l'utisateur n'existe pas");
        else{
            return user;
        }
    }

    @Override
    public List<User> findAllUsers() {
        return userRespository.findAll();
    }

    @Override
    public User findUserByEmail(String email) {
        User user=userRespository.getUserByEmail(email);
        if(user == null)
            throw new IllegalStateException("l'utisateur n'existe pas");
        else{
            return user;
        }
    }

    public UserDetails findByEmail(String email){
        User user = userRespository.getUserByEmail(email);
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority(user.getRole().getName())));
    }

    public User loadUserByUsername(String email){
        return userRespository.getUserByEmail(email);
    }
}
