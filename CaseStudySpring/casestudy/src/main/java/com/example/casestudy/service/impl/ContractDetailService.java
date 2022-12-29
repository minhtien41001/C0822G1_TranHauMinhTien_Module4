package com.example.casestudy.service.impl;

import com.example.casestudy.model.contract.ContractDetail;
import com.example.casestudy.repository.contract.IContractDetailRepository;
import com.example.casestudy.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    IContractDetailRepository iContractDetailRepository;
    @Override
    public List<ContractDetail> findAll() {
        return iContractDetailRepository.findAll();
    }

    @Override
    public Optional<ContractDetail> findById(int id) {
        return iContractDetailRepository.findById(id);
    }
}
