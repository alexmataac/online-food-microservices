package com.example.customer_service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customer_service.entity.Customer;
import com.example.customer_service.exception.CustomerNotFoundException;
import com.example.customer_service.repository.CustomerRepository;
import com.example.customer_service.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Override
    public Customer registerCustomer(Customer customer) {
        // TODO Auto-generated method stub

        return repository.save(customer);
    }

    @Override
    public Customer getCustomer(Long id) {
        // TODO Auto-generated method stub

        return repository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer Not Found with ID: " + id));
    }

    @Override
    public List<Customer> getAllCustomers() {
        // TODO Auto-generated method stub

        return repository.findAll();
    }

}
