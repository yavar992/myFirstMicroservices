package com.sampleMicroservices.employeeservices.Controller;

import com.sampleMicroservices.employeeservices.Repo.EmployeeRepo;
import com.sampleMicroservices.employeeservices.Service.EmployeeService;
import com.sampleMicroservices.employeeservices.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee add(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @GetMapping
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id){
        return employeeService.findById(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> findByDepartmentId(@PathVariable Long departmentId){
        log.info("list of employees by departmentId : {}", employeeService.findByDepartmentId(departmentId));
        return employeeService.findByDepartmentId(departmentId);
    }

}
