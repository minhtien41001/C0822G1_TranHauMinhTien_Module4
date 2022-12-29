package com.example.casestudy.service.impl;

import com.example.casestudy.model.facility.Facility;
import com.example.casestudy.repository.facility.IFacilityRepository;
import com.example.casestudy.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FacilityService implements IFacilityService {
    @Autowired
    IFacilityRepository iFacilityRepository;
    @Override
    public List<Facility> findAll() {
        return iFacilityRepository.findAll();
    }

    @Override
    public void save(Facility facility) {
        iFacilityRepository.save(facility);
    }

    @Override
    public Page<Facility> searchFacility(String nameSearch, Pageable pageable) {
        return iFacilityRepository.searchFacility(nameSearch,pageable);
    }

    @Override
    public Page<Facility> searchFacility1(String nameSearch, String facilityType, Pageable pageable) {
        return iFacilityRepository.searchFacility1(nameSearch,facilityType,pageable);
    }

    @Override
    public void remove(int id) {
        iFacilityRepository.deleteById(id);
    }

    @Override
    public void update(Facility facility) {
        iFacilityRepository.save(facility);
    }

    @Override
    public Optional<Facility> findById(int id) {
        return iFacilityRepository.findById(id);
    }
}
