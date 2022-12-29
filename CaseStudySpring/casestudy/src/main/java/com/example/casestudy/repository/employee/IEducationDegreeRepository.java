package com.example.casestudy.repository.employee;

import com.example.casestudy.model.employee.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface IEducationDegreeRepository extends JpaRepository<EducationDegree,Integer> {
}
