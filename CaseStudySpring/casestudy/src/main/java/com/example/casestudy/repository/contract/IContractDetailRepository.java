package com.example.casestudy.repository.contract;

import com.example.casestudy.dto.IContractDetailDto;
import com.example.casestudy.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IContractDetailRepository extends JpaRepository<ContractDetail,Integer> {
    @Query(value = "select attach_facility.name_attch as nameDto, " +
            "attach_facility.unit as unitDto, sum(ifnull(contract_detail.quantity, 0)) as quantityDto, " +
            "attach_facility.status as statusDto, attach_facility.cost as costDto " +
            "from contract_detail join attach_facility " +
            "on contract_detail.attach_facility_id = attach_facility.id " +
            "where contract_detail.contract_id = :idFind group by attach_facility.id;", nativeQuery = true)
    List<IContractDetailDto> showAll(@Param("idFind") Integer id);
}
