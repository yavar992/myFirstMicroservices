package com.sampleMicroservices.employeeservices.Repo;

import com.sampleMicroservices.employeeservices.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee , Long> {

    @Query(value = "SELECT * FROM `employee` WHERE departmentId = ?1" ,nativeQuery = true)
    List<Employee> findByDepartmentId(Long departmentId);
}
