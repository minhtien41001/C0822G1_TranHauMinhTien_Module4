package com.example.casestudy.repository.contract;

import com.example.casestudy.dto.IContractDto;
import com.example.casestudy.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IContractRepository extends JpaRepository<Contract,Integer> {
    @Query(value = "select contract.id as contractId, contract.start_date as startDate, " +
            "contract.end_date as endDate, contract.deposit as deposit, facility.name as facilityName, " +
            "employee.name as employeeName, customer.name as customerName, " +
            "(facility.cost + contract.deposit + " +
            "sum(ifnull(contract_detail.quantity, 0) * ifnull(attach_facility.cost, 0))) " +
            "as totalMoney " +
            "from contract " +
            "left join facility on contract.facility_id = facility.id " +
            "left join employee on contract.employee_id = employee.id " +
            "left join customer on contract.customer_id = customer.id " +
            "left join contract_detail on contract_detail.contract_id = contract.id " +
            "left join attach_facility on attach_facility.id = contract_detail.attach_facility_id " +
            "group by contract.contract_id;",
            nativeQuery = true)
    List<IContractDto> findAllDto();

    @Query(value = "select contract.id as contractId, contract.start_date as startDate, " +
            "contract.end_date as endDate, contract.deposit as deposit, facility.name as facilityName, " +
            "employee.name as employeeName, customer.name as customerName, " +
            "(facility.cost + contract.deposit + " +
            "sum(ifnull(contract_detail.quantity, 0) * ifnull(attach_facility.cost, 0))) " +
            "as totalMoney " +
            "from contract " +
            "left join facility on contract.facility_id = facility.id " +
            "left join employee on contract.employee_id = employee.id " +
            "left join customer on contract.customer_id = customer.id " +
            "left join contract_detail on contract_detail.contract_id = contract.id " +
            "left join attach_facility on attach_facility.id = contract_detail.attach_facility_id " +
            "group by contract.id",
            countQuery = "select contract.id as contractId, contract.start_date as startDate, " +
                    "contract.end_date as endDate, contract.deposit as deposit, facility.name as facilityName, " +
                    "employee.name as employeeName, customer.name as customerName, " +
                    "(facility.cost + contract.deposit + " +
                    "sum(ifnull(contract_detail.quantity, 0) * ifnull(attach_facility.cost, 0))) " +
                    "as totalMoney " +
                    "from contract " +
                    "left join facility on contract.facility_id = facility.id " +
                    "left join employee on contract.employee_id = employee.id " +
                    "left join customer on contract.customer_id = customer.id " +
                    "left join contract_detail on contract_detail.contract_id = contract.id " +
                    "left join attach_facility on attach_facility.id = contract_detail.attach_facility_id " +
                    "group by contract.id",
            nativeQuery = true)
    Page<IContractDto> findAllDto(Pageable pageable);
}
