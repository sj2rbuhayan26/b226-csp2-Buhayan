package com.joysistvi.recordingapp.Service;

import com.joysistvi.recordingapp.Model.User;

import java.util.List;


public interface UserService {

    // Create
    void addUser(User user);

    // Read all users
    List<User> getAllUsers();

    // Read user by ID
    User getUserById(int id);

    // Update
    void updateUser(User user);

    // Delete
    void deleteUser(int id);

    // Login
    User login(String username, String password);
}