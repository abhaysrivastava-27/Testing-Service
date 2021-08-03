package com.project.springboot.repository;

import com.project.springboot.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository  extends JpaRepository<Department,Long> {
    public Department findByDepartmentName(String Departname);
}
