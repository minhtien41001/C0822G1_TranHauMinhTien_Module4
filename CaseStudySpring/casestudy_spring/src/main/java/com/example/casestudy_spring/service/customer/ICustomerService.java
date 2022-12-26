package com.example.casestudy_spring.service.customer;

import com.example.casestudy_spring.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICustomerService {
    Page<Customer> searchCustomer(String nameSearch, String emailSearch, String customerType, Pageable pageable);

    void save(Customer customer);

    void delete(int id);

    void update(Customer customer);

    Optional<Customer> findById(int id);
}
