package com.example.userAuth.AulaAutenticacao.service;

import com.example.userAuth.AulaAutenticacao.model.DTO.TokenOutputDTO;
import com.example.userAuth.AulaAutenticacao.model.DTO.UserInputDTO;
import com.example.userAuth.AulaAutenticacao.model.User;
import com.example.userAuth.AulaAutenticacao.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    public User saveUser(UserInputDTO userInputDTO) {
        User userInput = modelMapper.map(userInputDTO, User.class);
        userRepository.save(userInput);
        return userInput;
    }

    public TokenOutputDTO login(UserInputDTO userInputDTO) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userInputDTO.getNickname(),
                        userInputDTO.getPassword()
                ));
        User user = userRepository.findByNickname(userInputDTO.getNickname());
        String jwtToken = jwtService.generateToken(user);
        return TokenOutputDTO.builder().token(jwtToken).build();
    }

    public User getById(Long id) {
        return userRepository.findById(id).get();
    }
}
