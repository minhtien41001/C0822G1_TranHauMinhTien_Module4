package com.example.casestudy.repository.facility;

import com.example.casestudy.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacilityRepository extends JpaRepository<Facility,Integer> {

    @Query(value = "select * " +
            "from facility " +
            "where facility.name like %:nameSearch%",
            nativeQuery = true)

    Page<Facility> searchFacility(@Param("nameSearch") String nameSearch, Pageable pageable);



    @Query(value = "select * " +
            "from facility " +
            "where name like %:nameSearch% and facility_type_id like %:facilityType%"
            ,nativeQuery = true)

    Page<Facility> searchFacility1(@Param("nameSearch") String nameSearch,
                                   @Param("facilityType") String facilityType,
                                   Pageable pageable);
}
