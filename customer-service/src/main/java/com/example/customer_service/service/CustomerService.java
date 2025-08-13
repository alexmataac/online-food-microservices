package com.example.customer_service.service;

import java.util.List;

import com.example.customer_service.entity.Customer;

public interface CustomerService {

    Customer registerCustomer(Customer customer);

    Customer getCustomer(Long id);

    List<Customer> getAllCustomers();

}
