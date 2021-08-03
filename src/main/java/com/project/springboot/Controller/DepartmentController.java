package com.project.springboot.Controller;

import com.project.springboot.entity.Department;
import com.project.springboot.error.DepartmentIdNotFound;
import com.project.springboot.service.DepartmentService;
import com.project.springboot.service.DepartmentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    private static Logger logger = LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    DepartmentService departmentService;

    @PostMapping("/department")
    public Department saveDepartment(@Valid @RequestBody Department department){
        logger.info("Inside saveDepartment");
        return departmentService.saveDepartment(department);
    }
    @GetMapping("/department")
    public List<Department> getDepartment(){
        logger.info("Inside getDepartment");
        return departmentService.getDepartment();
    }

    @GetMapping("/department/{id}")
    public Department getDepartmentById(@PathVariable("id") long id) throws DepartmentIdNotFound {
        logger.info("Inside getDepartmentById");
        return departmentService.getDepartmentById(id);
    }

    @DeleteMapping("/department/{id}")
    public void deleteDepartmentById(@PathVariable("id") long id){
        logger.info("Inside deleteDepartmentById");
        departmentService.deleteDepartmentById(id);
    }

    @PutMapping("/department/{id}")
    public Department updateDepartmentById(@PathVariable("id") long id, @RequestBody Department department){
        logger.info("Inside updateDepartmentById");
        return departmentService.updateDepartmentById(id,department);
    }
    @GetMapping("/department/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String name){
        logger.info("Inside getDepartmentByName");
        return departmentService.getDepartmentByName(name);
    }

}
