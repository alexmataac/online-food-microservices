package com.example.restaurant_service.service;

import java.util.List;

import com.example.restaurant_service.entity.Restaurant;

public interface RestaurantService {

    Restaurant createRestaurant(Restaurant restaurant);

    Restaurant getRestaurant(Long id);

    List<Restaurant> getAllRestaurants();

}
