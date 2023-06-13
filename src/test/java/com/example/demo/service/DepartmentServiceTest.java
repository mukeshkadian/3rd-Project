package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department= Department.builder().departmentName("IT").departmentAddress("Delhi")
                .departmentCode("IT-02").departmentId(1L).build();
                 Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT")).
                thenReturn(department);
    }

   @Test
   @DisplayName("Get Data base on Valid Department Name")
    public void  whenValidDepartmentName_thenDepartmentShouldFound(){
        String departmentName="IT";
       Department found = departmentService.fetchDepartmentName(departmentName);
       assertEquals(departmentName, found.getDepartmentName());
   }


}