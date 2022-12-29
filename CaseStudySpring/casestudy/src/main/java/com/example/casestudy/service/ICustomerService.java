package com.example.casestudy.service;

import com.example.casestudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Page<Customer> searchCustomer(String nameSearch, String emailSearch, String addressSearch, Pageable pageable);

    Page<Customer> searchCustomer1(String nameSearch, String emailSearch, String customerType, Pageable pageable);

    void delete(int id);

    void update(Customer customer);

    Optional<Customer> findById(int id);
}
