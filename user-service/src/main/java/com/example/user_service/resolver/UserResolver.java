package com.example.user_service.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.user_service.entity.User;
import com.example.user_service.exception.UserNotFoundException;
import com.example.user_service.serviceImpl.UserServiceImpl;

@Controller
public class UserResolver {

    @Autowired
    private UserServiceImpl serviceImpl;

    @QueryMapping
    public List<User> allUsers() {
        return serviceImpl.getUsersList();
    }

    @QueryMapping
    public User userById(@Argument Long id) throws UserNotFoundException {
        return serviceImpl.getUserById(id);
    }

    @MutationMapping
    public User registerUser(@Argument String username, @Argument String password, @Argument String role) {
        return serviceImpl.registerUser(username, password, role);
    }

    @MutationMapping
    public String login(@Argument String username, @Argument String password) {
        return serviceImpl.authenticate(username, password);
    }
}
