package com.example.casestudy.repository.customer;

import com.example.casestudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
    @Query(value = "select * from customer where name like %:nameSearch%  " +
            "and email like %:emailSearch% and customer_type_id like  %:customerType%"
//            ,
//            countQuery = "select * from customer where name like %:nameSearch%  " +
//                    "and email like %:emailSearch% and customer_type_id like  %:customerType%"
            ,nativeQuery = true)
    Page<Customer> searchCustomer1(@Param("nameSearch") String nameSearch,
                                   @Param("emailSearch") String emailSearch,
                                   @Param("customerType") String customerType,
                                   Pageable pageable);

    @Query(value = "select * from cusomer " +
            "where customer.name like %:nameSearch% " +
            "and customer.email like %:emailSearch " +
            "and customer.address like %:addressSearch%", nativeQuery = true)
    Page<Customer> searchCustomer(@Param("nameSearch") String nameSearch,
                                  @Param("emailSearch") String emailSearch,
                                  @Param("addressSearch") String addressSearch,
                                  Pageable pageable
                                  );

}
