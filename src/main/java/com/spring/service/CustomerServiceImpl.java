package com.spring.service;

import com.spring.model.Customer;
import com.spring.repository.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by binlix26 on 4/06/17.
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public List<Customer> getCustomers() {
        return customerDao.getCustomers();
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerDao.saveCustomer(customer);
    }

    @Override
    public Customer getCustomer(int id) {
       return customerDao.getCustomer(id);
    }

    @Override
    public void deleteCustomer(int id) {
        customerDao.deleteCustomer(id);
    }

    @Override
    public List<Customer> searchCustomers(String name) {
        return customerDao.searchCustomers(name);
    }
}
