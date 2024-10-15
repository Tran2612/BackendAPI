package com.project.backendapi.controller;

import com.project.backendapi.model.Users;
import com.project.backendapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public Optional<Users> getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }
    @PostMapping("/")
    public Users createUser(@RequestBody Users user) {
        return userService.save(user);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
    @PutMapping("/{id}")
    public Users updateUser(@PathVariable int id, @RequestBody Users user) {
        Optional<Users> users = userService.getUserById(id);
        if (users.isPresent()) {
            Users userToUpdate = users.get();
            userToUpdate.setFirstName(user.getFirstName());
            userToUpdate.setLastName(user.getLastName());
            userToUpdate.setEmail(user.getEmail());
            userToUpdate.setPassword(user.getPassword());
            userToUpdate.setAddress(user.getAddress());
            userToUpdate.setPhoneNumber(user.getPhoneNumber());
            userToUpdate.setCity(user.getCity());
            userToUpdate.setCountry(user.getCountry());
            return userService.save(userToUpdate);

        }
        return userService.save(user);
    }
}
