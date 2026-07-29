package com.joysistvi.recordingapp.Controller;

import com.joysistvi.recordingapp.Model.User;
import com.joysistvi.recordingapp.Service.UserService;

import java.util.List;

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Create User
    public void addUser(User user) {
        userService.addUser(user);
    }

    // Read All Users
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Read User by ID
    public User getUserById(int id) {
        return userService.getUserById(id);
    }

    // Update User
    public void updateUser(User user) {
        userService.updateUser(user);
    }

    // Delete User
    public void deleteUser(int id) {
        userService.deleteUser(id);
    }

    // Register User
    public boolean register(User user){
        return userService.register(user);
    }
    // Login
    public User login(String username, String password) {
        return userService.login(username, password);
    }
}