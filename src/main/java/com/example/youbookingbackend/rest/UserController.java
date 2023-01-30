package com.example.youbookingbackend.rest;

import com.example.youbookingbackend.Config.JwtUtil;
import com.example.youbookingbackend.entity.Role;
import com.example.youbookingbackend.repository.RoleRespository;
import com.example.youbookingbackend.repository.dto.AuthenticationDto;
import com.example.youbookingbackend.repository.dto.ResponseDto;
import com.example.youbookingbackend.repository.dto.UserDto;
import com.example.youbookingbackend.entity.User;
import com.example.youbookingbackend.service.UserService;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Transactional
@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin("http://localhost:60435/")
public class UserController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private RoleRespository roleRespository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;
    @PostMapping("/add_user")
    public UserDto addUser(@RequestBody UserDto userDto){
        return userService.addUser(userDto);
    }

    @PutMapping("/update_user")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @GetMapping("/AllUsers")
    public List<User> getAllUsers(){
        return userService.findAllUsers();
    }

    @PostMapping("/addRole")
    public Role addRole(@RequestBody Role role){
        return roleRespository.save(role);
    }


    @GetMapping("/AllRoles")
    public List<Role> getRoles(){return roleRespository.findAll();}

    @PostMapping("/auth/authenticate")
    public ResponseDto authenticate(@RequestBody AuthenticationDto request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword())
        );
        final UserDetails user =userDetailsService.loadUserByUsername(request.getEmail());

        if(user!=null){
            return new ResponseDto("success","message",jwtUtil.generateToken(user));
        }
        return  new ResponseDto("error","some error has occured");
    }














//    @Autowired
//    private UserService userService;
//    @PostMapping("/add_user")
//    public User addUser(@RequestBody User user){
//        return userService.addUser(user);
//    }
//
//    @PutMapping("/update_user")
//    public User updateUser(@RequestBody User user){
//        return userService.updateUser(user);
//    }
//
//    @GetMapping("/AllUsers")
//    public List<User> getAllUsers(){
//        return userService.findAllUsers();
//    }

}
