package com.joysistvi.recordingapp.Service;

import com.joysistvi.recordingapp.Model.User;
import com.joysistvi.recordingapp.Repository.UserRepo;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void addUser(User user) {
        userRepo.addUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.getAllUsers();
    }

    @Override
    public User getUserById(int id) {
        return userRepo.getUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userRepo.updateUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userRepo.deleteUser(id);
    }
    @Override
    public User login(String username, String password){
        return userRepo.login(username, password);
    }
}