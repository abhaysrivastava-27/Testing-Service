package com.project.springboot.service;

import com.project.springboot.entity.Department;
import com.project.springboot.error.DepartmentIdNotFound;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> getDepartment();

    Department getDepartmentById(long id) throws DepartmentIdNotFound;

    void deleteDepartmentById(long id);

    Department updateDepartmentById(long id, Department department);

    Department getDepartmentByName(String name);
}
