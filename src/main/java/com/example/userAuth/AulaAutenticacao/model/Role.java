package com.example.userAuth.AulaAutenticacao.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
public enum Role {
    DEFAULT,
    USER,
    ADMIN
}
