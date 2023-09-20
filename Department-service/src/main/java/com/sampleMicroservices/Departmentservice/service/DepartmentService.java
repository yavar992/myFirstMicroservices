package com.sampleMicroservices.Departmentservice.service;

import com.sampleMicroservices.Departmentservice.entity.Department;
import com.sampleMicroservices.Departmentservice.entity.Employee;
import com.sampleMicroservices.Departmentservice.repo.DepartmentRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient webClient;


    public Department add(Department department){
        return departmentRepo.saveAndFlush(department);
    }

    public Department findById(Long id){
        return departmentRepo.findById(id).orElseThrow();
    }

    public List<Department> findAll(){
        return departmentRepo.findAll();
    }

    public List<Department> findAllDepartmentData() {
        //http://localhost:8082/employee
        List<Department> departments = departmentRepo.findAll();
//        Employee[] employees = restTemplate.getForEntity("http://EMPLOYEE-SERVICE/employee",Employee[].class).getBody();
//        log.info("Employee :{}",employees);
//
//        for (Department department : departments) {
//            List<Employee> departmentEmployees = new ArrayList<>();
//            for (Employee employee : employees){
//                if (employee.getDepartmentId()==department.getId()){
//                    departmentEmployees.add(employee);
//                }
//            }
//            department.setEmployee(departmentEmployees);
//        }
//        return departments;

        List<Employee> employees = webClient.get().uri("").retrieve().bodyToFlux(Employee.class).collectList().block();
        log.info("Employees :{}",employees);
        for(Department department : departments){
            List<Employee> employees1 = new ArrayList<>();
            for (Employee employee : employees){
                if (employee.getDepartmentId()==department.getId()){
                    employees1.add(employee);
                }
            }
            department.setEmployee(employees1);
        }
        return departments;
    }

    public Department findDepartmentDataWithEmployeesByDepartmentId(Long id) {
//        http://localhost:8082/employee/department/"+id
        Department department = findById(id);

//        ArrayList<Employee> departmentEmployee =
//                restTemplate.getForObject("http://EMPLOYEE-SERVICE/employee/department/" + id , ArrayList.class);
//        log.info("departmentEmployee : {}",departmentEmployee);
//        department.setEmployee(departmentEmployee);
//        return department;

//        List<Object> objects = webClient.get().uri("https://jsonplaceholder.typicode.com/posts/3")
//                .retrieve().bodyToFlux(Object.class).collectList().block();
//        log.info("objects : {}",objects);
//
//        List<Mono<Object>> monos = webClient.get().uri("https://jsonplaceholder.typicode.com/posts/1")
//                .retrieve().bodyToFlux(Object.class)
//                .toStream().map(Mono::just).collect(Collectors.toList());
//        log.info("mono : {}",monos.stream().toList());

        //using webclient
        List<Employee> employees = webClient.get().uri("/department/"+id , id).retrieve()
                .bodyToFlux(Employee.class).collectList().block();
                log.info("employee : {}",employees);
        department.setEmployee(employees);
        return department;
    }
}
