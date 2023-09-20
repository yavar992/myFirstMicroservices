package com.sampleMicroservices.Departmentservice.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String departmentName;

    @Transient
    private List<Employee> employee = new ArrayList<>();

    public Department(Long id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }
}
