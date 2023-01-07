package com.example.casestudy.service;

import com.example.casestudy.dto.IContractDetailDto;
import com.example.casestudy.model.contract.ContractDetail;

import java.util.List;
import java.util.Optional;

public interface IContractDetailService {
    List<ContractDetail> findAll();

    void save(ContractDetail contractDetail);

    List<IContractDetailDto> showAll(Integer id);
}
