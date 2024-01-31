package com.example.userAuth.AulaAutenticacao.model.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TokenOutputDTO {
    String token;
}
