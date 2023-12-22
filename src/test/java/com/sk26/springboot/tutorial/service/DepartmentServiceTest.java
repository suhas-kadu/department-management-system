package com.sk26.springboot.tutorial.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sk26.springboot.tutorial.entity.Department;
import com.sk26.springboot.tutorial.repository.DepartmentRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("CS")
                .departmentAddress("Pune")
                .departmentCode("CS-15")
                .departmentId(1L)
                .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("CS")).thenReturn(department);
        Mockito.when(departmentRepository.findByDepartmentNameAndDepartmentCodeIgnoreCase("CS",
                "CS-15"))
                .thenReturn(department);
    }

    @Test
    @DisplayName("Get Data based on Valida Department Name")
    public void testGetDepartmentByName() {
        String departmentName = "CS";
        Department found = departmentService.getDepartmentByName(departmentName);

        assertEquals(departmentName, found.getDepartmentName());
    }

    @Test
    public void testGetDepartmentByNameAndCode() {
        String departmentName = "CS";
        String departmentCode = "CS-15";

        Department departmentFound = departmentService.getDepartmentByNameAndCode(departmentName, departmentCode);

        assertEquals(departmentName, departmentFound.getDepartmentName());
        assertEquals(departmentCode, departmentFound.getDepartmentCode());

    }
}