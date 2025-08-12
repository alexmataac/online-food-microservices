package com.example.user_service.service;

import java.util.List;

import com.example.user_service.entity.User;
import com.example.user_service.exception.UserNotFoundException;

public interface UserService {

    List<User> getUsersList();

    User getUserById(Long id) throws UserNotFoundException;

    User registerUser(String username, String password, String role);

    String authenticate(String username, String password);
}
