package com.example.borrow_books.service.impl;
import com.example.borrow_books.model.Oder;
import com.example.borrow_books.repository.IOderRepository;
import com.example.borrow_books.service.IOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OderService implements IOderService {

    @Autowired
    private IOderRepository oderRepository;

    @Override
    public List<Oder> findAll() {
        return oderRepository.findAll();
    }

    @Override
    public Optional<Oder> findById(int id) {
        return oderRepository.findById(id);
    }

    @Override
    public void save(Oder oder) {
        oderRepository.save(oder);
    }

    @Override
    public void remove(int id) {
        oderRepository.deleteById(id);
    }

    @Override
    public Oder findByCode(long code) {
        return oderRepository.findByOder(code);
    }
}