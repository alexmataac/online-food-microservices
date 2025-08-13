package com.example.restaurant_service.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.restaurant_service.entity.Restaurant;
import com.example.restaurant_service.serviceImpl.RestaurantServiceImpl;

@Controller
public class RestaurantResolver {

    @Autowired
    private RestaurantServiceImpl serviceImpl;

    @MutationMapping
    public Restaurant addRestaurant(@Argument String name, @Argument String address, @Argument String phone) {

        Restaurant restaurant = new Restaurant();
        restaurant.setName(name);
        restaurant.setAddress(address);
        restaurant.setPhone(phone);
        return serviceImpl.createRestaurant(restaurant);
    }

    @QueryMapping
    public Restaurant getRestaurant(@Argument Long id) {
        return serviceImpl.getRestaurant(id);
    }

    @QueryMapping
    public List<Restaurant> getAllRestaurants() {
        return serviceImpl.getAllRestaurants();
    }
}
