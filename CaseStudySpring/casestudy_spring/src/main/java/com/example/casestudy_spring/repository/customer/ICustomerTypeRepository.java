package com.example.casestudy_spring.repository.customer;
import com.example.casestudy_spring.model.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerTypeRepository extends JpaRepository<CustomerType,Integer> {

}
