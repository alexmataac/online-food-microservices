package com.example.restaurant_service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restaurant_service.entity.Restaurant;
import com.example.restaurant_service.exception.RestaurantNotFoundException;
import com.example.restaurant_service.repository.RestaurantRepository;
import com.example.restaurant_service.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository repository;

    @Override
    public Restaurant createRestaurant(Restaurant restaurant) {
        // TODO Auto-generated method stub

        return repository.save(restaurant);
    }

    @Override
    public Restaurant getRestaurant(Long id) {
        // TODO Auto-generated method stub

        return repository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant Not Found with ID: " + id));

    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        // TODO Auto-generated method stub

        return repository.findAll();

    }

}
