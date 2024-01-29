package com.example.userAuth.AulaAutenticacao.service;

import com.example.userAuth.AulaAutenticacao.model.DTO.UserInputDTO;
import com.example.userAuth.AulaAutenticacao.model.User;
import com.example.userAuth.AulaAutenticacao.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public User saveUser(UserInputDTO userInputDTO) {
        User userInput = modelMapper.map(userInputDTO, User.class);
        userRepository.save(userInput);
        return userInput;
    }
}
