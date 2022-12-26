package com.example.casestudy_spring.repository.customer;

import com.example.casestudy_spring.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
    @Query(value = "select * from customer " +
            "where name like %:nameSearch% " +
            "and email like %:emailSearch% " +
            "and customer_type_id like  %:customerType% " +
            "and is_delete = 1",nativeQuery = true)
    Page<Customer> searchCustomer(@Param("nameSearch") String nameSearch,
                                  @Param("emailSearch") String emailSearch,
                                  @Param("customerType") String customerType,
                                  Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "update customer set is_delete = 0 where id = :id",nativeQuery = true)
    void deleteCustomer(@Param("id") int id);
}
