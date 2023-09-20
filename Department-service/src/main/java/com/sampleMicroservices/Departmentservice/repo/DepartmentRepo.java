package com.sampleMicroservices.Departmentservice.repo;

import com.sampleMicroservices.Departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DepartmentRepo extends JpaRepository<Department , Long> {


}
