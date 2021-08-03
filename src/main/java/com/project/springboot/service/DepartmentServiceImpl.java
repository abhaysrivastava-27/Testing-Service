package com.project.springboot.service;

import com.project.springboot.entity.Department;
import com.project.springboot.error.DepartmentIdNotFound;
import com.project.springboot.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements  DepartmentService{
    @Autowired
    DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(long id) throws DepartmentIdNotFound {

        Optional<Department> department =  departmentRepository.findById(id);
        if(!department.isPresent()){
            throw new DepartmentIdNotFound("Department Not Found");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById(long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartmentById(long id, Department department) {
        Department dbData = departmentRepository.findById(id).get();
        if(Objects.nonNull(department.getDepartmentAddress())&&
        !"".equalsIgnoreCase(department.getDepartmentAddress())){
            dbData.setDepartmentAddress(department.getDepartmentAddress());
        }
        if(Objects.nonNull(department.getDepartmentCode())&&
                !"".equalsIgnoreCase(department.getDepartmentCode())){
            dbData.setDepartmentCode(department.getDepartmentCode());
        }
        if(Objects.nonNull(department.getDepartmentName())&&
                !"".equalsIgnoreCase(department.getDepartmentName())){
            dbData.setDepartmentName(department.getDepartmentName());
        }
        departmentRepository.save(dbData);
        return dbData;
    }

    @Override
    public Department getDepartmentByName(String name) {
        return departmentRepository.findByDepartmentName(name);
    }
}
