package com.sampleMicroservices.Departmentservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.AccessType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private int id;
    private int departmentId;
    private String name;
    private int age;
    private String position;


}
