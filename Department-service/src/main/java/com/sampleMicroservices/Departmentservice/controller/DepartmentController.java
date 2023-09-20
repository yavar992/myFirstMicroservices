package com.sampleMicroservices.Departmentservice.controller;
import com.sampleMicroservices.Departmentservice.entity.Department;
import com.sampleMicroservices.Departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public Department addDepartment(@RequestBody Department department){
        return departmentService.add(department);
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable Long id){
        return departmentService.findById(id);
    }

    @GetMapping
    public List<Department> findAll(){
        return departmentService.findAll();
    }

    @GetMapping("/allData")
    public List<Department> getAllDepartmentData(){
        return departmentService.findAllDepartmentData();
    }

    @GetMapping("/data/{id}")
    public Department findAllDepartmentWithEmployeesByDepartmentId(@PathVariable Long id){
        return departmentService.findDepartmentDataWithEmployeesByDepartmentId(id);
    }




}
