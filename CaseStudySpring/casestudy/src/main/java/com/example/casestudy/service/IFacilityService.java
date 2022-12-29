package com.example.casestudy.service;

import com.example.casestudy.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IFacilityService {
    List<Facility> findAll();

    void save(Facility facility);

    Page<Facility> searchFacility(String nameSearch, Pageable pageable);

    Page<Facility> searchFacility1(String nameSearch,String facilityType,Pageable pageable);

    void remove (int id);

    void update(Facility facility);

    Optional<Facility> findById(int id);
}
