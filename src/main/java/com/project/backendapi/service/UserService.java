package com.project.backendapi.service;

import com.project.backendapi.model.Users;
import com.project.backendapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }
    public Optional<Users> getUserById(long id) {
        return userRepository.findById(id);
    }
    public Users save(Users user) {
        return userRepository.save(user);
    }
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}
