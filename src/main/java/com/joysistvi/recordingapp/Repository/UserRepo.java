package com.joysistvi.recordingapp.Repository;

import com.joysistvi.recordingapp.Model.User;

import java.util.List;

public interface UserRepo {

    void addUser(User user);

    List<User> getAllUsers();

    void updateUser(User user);

    void deleteUser(int id);

    User getUserById(int id);

    User login(String username, String password);
}
