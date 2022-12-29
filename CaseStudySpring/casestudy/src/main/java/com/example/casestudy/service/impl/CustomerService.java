package com.example.casestudy.service.impl;

import com.example.casestudy.model.customer.Customer;
import com.example.casestudy.repository.customer.ICustomerRepository;
import com.example.casestudy.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Page<Customer> searchCustomer(String nameSearch, String emailSearch, String addressSearch, Pageable pageable) {
        return iCustomerRepository.searchCustomer(nameSearch,emailSearch,addressSearch,pageable);
    }

    @Override
    public Page<Customer> searchCustomer1(String nameSearch, String emailSearch, String customerType, Pageable pageable) {
        return iCustomerRepository.searchCustomer1(nameSearch,emailSearch,customerType,pageable);
    }

    @Override
    public void delete(int id) {
        iCustomerRepository.deleteById(id);
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
