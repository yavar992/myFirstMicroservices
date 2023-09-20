package com.sampleMicroservices.employeeservices.Service;

import com.sampleMicroservices.employeeservices.Repo.EmployeeRepo;
import com.sampleMicroservices.employeeservices.entity.Employee;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public Employee addEmployee(Employee employee){
        return employeeRepo.saveAndFlush(employee);
    }


    public List<Employee> findAll(){
        return employeeRepo.findAll();
    }

    public Employee findById(Long id){
        return employeeRepo.findById(id).orElseThrow();
    }

    public List<Employee> findByDepartmentId(Long departmentId){
        return employeeRepo.findByDepartmentId(departmentId);
    }
}
