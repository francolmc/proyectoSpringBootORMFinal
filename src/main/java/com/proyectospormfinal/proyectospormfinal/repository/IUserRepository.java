package com.proyectospormfinal.proyectospormfinal.repository;

import java.util.List;

import com.proyectospormfinal.proyectospormfinal.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
    public User findByEmail(String email);
    public List<User> findByEmailOrFirstNameOrLastName(String email, String firstName, String lastName);
}
