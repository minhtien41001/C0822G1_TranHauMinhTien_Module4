package com.example.casestudy.service.impl;

import com.example.casestudy.model.employee.EducationDegree;
import com.example.casestudy.repository.employee.IEducationDegreeRepository;
import com.example.casestudy.service.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EducationDegreeService implements IEducationDegreeService {
    @Autowired
    IEducationDegreeRepository iEducationDegreeRepository;
    @Override
    public List<EducationDegree> findAll() {
        return iEducationDegreeRepository.findAll();
    }
}
