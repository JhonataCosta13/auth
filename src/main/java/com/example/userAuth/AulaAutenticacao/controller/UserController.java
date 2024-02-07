package com.example.userAuth.AulaAutenticacao.controller;

import com.example.userAuth.AulaAutenticacao.model.DTO.TokenOutputDTO;
import com.example.userAuth.AulaAutenticacao.model.DTO.UserInputDTO;
import com.example.userAuth.AulaAutenticacao.model.User;
import com.example.userAuth.AulaAutenticacao.service.UserService;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> userRegister(@RequestBody UserInputDTO userInputDTO){

        User userOutput = userService.saveUser(userInputDTO);
        URI location = UriComponentsBuilder.
                fromUriString("http://localhost:8080/user/{id}").
                buildAndExpand(userOutput.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PostMapping("/login")
    public ResponseEntity<TokenOutputDTO> login(@RequestBody UserInputDTO userInputDTO){

        TokenOutputDTO jwtToken = userService.login(userInputDTO);


        return ResponseEntity.ok().body(jwtToken);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id){
        User user = userService.getById(id);
        return ResponseEntity.ok().body(user);
    }
}
