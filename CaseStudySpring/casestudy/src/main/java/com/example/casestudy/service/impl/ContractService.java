package com.example.casestudy.service.impl;

import com.example.casestudy.dto.IContractDto;
import com.example.casestudy.model.contract.Contract;
import com.example.casestudy.repository.contract.IContractRepository;
import com.example.casestudy.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
    IContractRepository iContractRepository;

    @Override
    public void save(Contract contract) {
        iContractRepository.save(contract);
    }

    @Override
    public List<IContractDto> findAllDto() {
        return iContractRepository.findAllDto();
    }

    @Override
    public Page<IContractDto> findAllDto(Pageable pageable) {
        return iContractRepository.findAllDto(pageable);
    }
}
