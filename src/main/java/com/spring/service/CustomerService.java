package com.spring.service;

import com.spring.model.Customer;

import java.util.List;

/**
 * Created by binlix26 on 4/06/17.
 */
public interface CustomerService {
    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(int id);

    void deleteCustomer(int id);

    List<Customer> searchCustomers(String name);
}
