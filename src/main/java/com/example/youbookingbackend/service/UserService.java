package com.example.youbookingbackend.service;

import com.example.youbookingbackend.repository.dto.UserDto;
import com.example.youbookingbackend.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {

    UserDto addUser(UserDto userDto);
    User updateUser(User user);
    User DesactiveUser(Long idUser);
    User getUser(Long idUser);
    List<User> findAllUsers();
    User findUserByEmail(String email);
    UserDetails findByEmail(String email);
    User loadUserByUsername(String email);

}
