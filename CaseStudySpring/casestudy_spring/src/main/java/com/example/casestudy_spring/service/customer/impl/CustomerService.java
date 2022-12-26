package com.example.casestudy_spring.service.customer.impl;

import com.example.casestudy_spring.model.customer.Customer;
import com.example.casestudy_spring.repository.customer.ICustomerRepository;
import com.example.casestudy_spring.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Page<Customer> searchCustomer(String nameSearch, String emailSearch, String customerType, Pageable pageable) {
        return iCustomerRepository.searchCustomer(nameSearch, emailSearch, customerType, pageable);
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public void delete(int id) {
        iCustomerRepository.deleteCustomer(id);
    }

    @Override
    public void update(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findById(int id) {
        return iCustomerRepository.findById(id);
    }
}
