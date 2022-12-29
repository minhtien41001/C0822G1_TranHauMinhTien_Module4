package com.example.casestudy.service.impl;

import com.example.casestudy.model.employee.Position;
import com.example.casestudy.repository.employee.IPositionRepository;
import com.example.casestudy.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionService implements IPositionService {
    @Autowired
    IPositionRepository iPositionRepository;
    @Override
    public List<Position> findAll() {
        return iPositionRepository.findAll();
    }
}
