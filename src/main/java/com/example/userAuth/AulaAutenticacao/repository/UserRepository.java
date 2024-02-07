package com.example.userAuth.AulaAutenticacao.repository;

import com.example.userAuth.AulaAutenticacao.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByNickname(String nickname);
}
