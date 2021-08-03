package com.project.springboot.Controller;

import com.project.springboot.entity.Department;
import com.project.springboot.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

 @Autowired
private MockMvc mockMvc;

 @MockBean
 private DepartmentService departmentService;

 private Department outputDepartment;

    @BeforeEach
    void setUp() {
        outputDepartment =
                Department.builder()
                        .departmentAddress("Ahemdabad")
                        .departmentCode("21")
                        .departmentId(1l)
                        .departmentName("CS")
                        .build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment =
                Department.builder()
                        .departmentAddress("Ahemdabad")
                        .departmentCode("21")
                        .departmentName("CS")
                        .build();
      when(departmentService.saveDepartment(inputDepartment)).thenReturn(outputDepartment);
      mockMvc.perform(MockMvcRequestBuilders.post("/department")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\n" +
          "        \"departmentName\": \"CS\",\n" +
          "        \"departmentAddress\": \"Ahemdabad\",\n" +
          "        \"departmentCode\": \"21\"\n" +
          "}"))
        .andExpect(MockMvcResultMatchers.status().isOk());

    }
}