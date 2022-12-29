package com.example.casestudy.service.impl;

import com.example.casestudy.model.employee.Employee;
import com.example.casestudy.repository.employee.IEmployeeRepository;
import com.example.casestudy.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    IEmployeeRepository iEmployeeRepository;

    @Override
    public List<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }
}
