package com.example.userAuth.AulaAutenticacao.repository;

import com.example.userAuth.AulaAutenticacao.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
