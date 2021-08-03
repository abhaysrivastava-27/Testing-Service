package com.project.springboot.repository;

import com.project.springboot.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .departmentAddress("Ahemdabad")
                        .departmentCode("21")
                        .departmentName("CS")
                        .build();
        entityManager.persist(department);
    }
    @Test
    public void gettingDepartmentByIdTest(){
        Department department = departmentRepository.findById(1l).get();
        assertEquals(department.getDepartmentName(),"CS");
    }
}