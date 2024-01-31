package com.example.userAuth.AulaAutenticacao.model.DTO;

import com.example.userAuth.AulaAutenticacao.model.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInputDTO {

    private String nickname;
    private String password;
    private Role role;
}
