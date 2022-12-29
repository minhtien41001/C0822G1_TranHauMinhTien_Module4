package com.example.casestudy.repository.contract;

import com.example.casestudy.model.contract.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAttachFacilityRepository extends JpaRepository<AttachFacility,Integer> {
}
