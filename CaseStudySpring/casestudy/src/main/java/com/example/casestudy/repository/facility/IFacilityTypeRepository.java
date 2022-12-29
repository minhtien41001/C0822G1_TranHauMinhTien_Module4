package com.example.casestudy.repository.facility;

import com.example.casestudy.model.facility.FacilityType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacilityTypeRepository extends JpaRepository<FacilityType,Integer> {
}
