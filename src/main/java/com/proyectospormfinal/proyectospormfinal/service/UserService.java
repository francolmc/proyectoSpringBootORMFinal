package com.proyectospormfinal.proyectospormfinal.service;

import java.util.List;

import com.proyectospormfinal.proyectospormfinal.model.User;
import com.proyectospormfinal.proyectospormfinal.repository.IUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IUserRepository _userJpaRepository;

    public List<User> getUsers() {
        return this._userJpaRepository.findAll();
    }

    public User createUser(User user) {
        return this._userJpaRepository.save(user);
    }

    public List<User> getUsersByFilter(String filter) {
        return this._userJpaRepository.findByEmailOrFirstNameOrLastName(filter, filter, filter);
    }

    public User editUser(Long id, User user) {
        User u = this._userJpaRepository.findById(id).get();
        u.setFirstName(user.getFirstName());
        u.setLastName(user.getLastName());
        return this._userJpaRepository.save(u);
    }

    public void deleteUser(Long id) {
        User user = this._userJpaRepository.findById(id).get();
        this._userJpaRepository.delete(user);
    }
    
    public User findByEmail(String email) {
        return this._userJpaRepository.findByEmail(email);
    }
}
