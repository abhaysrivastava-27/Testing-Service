package com.project.springboot.service;

import com.project.springboot.entity.Department;
import com.project.springboot.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceImplTest {

    @Autowired
    DepartmentService departmentService;

    @MockBean
    DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp(){
        Department department =
                Department.builder()
                .departmentAddress("Ahemdabad")
                .departmentCode("21")
                .departmentId(1l)
                .departmentName("CS")
                .build();
        Mockito.when(departmentRepository.findByDepartmentName("CS"))
                .thenReturn(department);
    }


    @Test
    void getDepartmentByName() {

        String departmentName = "CS";
        Department dep =  departmentService.getDepartmentByName(departmentName);
        assertEquals(departmentName,dep.getDepartmentName());
    }
}