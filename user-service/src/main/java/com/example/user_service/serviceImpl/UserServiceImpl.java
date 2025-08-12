package com.example.user_service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.user_service.entity.User;
import com.example.user_service.exception.UserNotFoundException;
import com.example.user_service.repository.UserRepository;
import com.example.user_service.security.JwtUtil;
import com.example.user_service.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public List<User> getUsersList() {
        // TODO Auto-generated method stub

        return repository.findAll();
    }

    @Override
    public User getUserById(Long id) throws UserNotFoundException {
        // TODO Auto-generated method stub

        return repository.findById(id).orElseThrow(() -> new UserNotFoundException("User with ID" + id + "not found"));
    }

    @Override
    public User registerUser(String username, String password, String role) {
        // TODO Auto-generated method stub
        User users = new User();
        users.setUsername(username);
        users.setPassword(passwordEncoder.encode(password));
        users.setRole(role);

        return repository.save(users);
    }

    @Override
    public String authenticate(String username, String password) {
        // TODO Auto-generated method stub

        User user = repository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));

        if (passwordEncoder.matches(password, user.getPassword())) {
            return jwtUtil.generateToken(user.getUsername(), user.getRole());
        } else {
            throw new RuntimeException("Invalid username or password");
        }
    }
}
