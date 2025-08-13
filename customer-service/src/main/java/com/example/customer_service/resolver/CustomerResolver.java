package com.example.customer_service.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.customer_service.entity.Customer;
import com.example.customer_service.serviceImpl.CustomerServiceImpl;

@Controller
public class CustomerResolver {

    @Autowired
    private CustomerServiceImpl serviceImpl;

    @MutationMapping
    public Customer addCustomer(@Argument String name, @Argument String email, @Argument String phone) {

        Customer customers = new Customer();
        customers.setName(name);
        customers.setEmail(email);
        customers.setPhone(phone);
        return serviceImpl.registerCustomer(customers);
    }

    @QueryMapping
    public Customer getCustomer(@Argument Long id) {
        return serviceImpl.getCustomer(id);
    }

    @QueryMapping
    public List<Customer> getAllCustomers() {
        return serviceImpl.getAllCustomers();
    }
}
