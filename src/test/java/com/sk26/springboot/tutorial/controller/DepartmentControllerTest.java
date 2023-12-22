package com.sk26.springboot.tutorial.controller;

import javax.print.attribute.standard.Media;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.creation.bytebuddy.MockAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.sk26.springboot.tutorial.entity.Department;
import com.sk26.springboot.tutorial.error.DepartmentNotException;
import com.sk26.springboot.tutorial.service.DepartmentService;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(DepartmentController.class)
public class DepartmentControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private DepartmentService departmentService;

        private Department department;

        @BeforeEach
        void setUp() {
                department = Department.builder().departmentId(1L).departmentName("cs")
                                .departmentAddress("pune").departmentCode("cs-15").build();

        }

        @Test
        void testGetDepartmentById() throws Exception {
                Mockito.when(departmentService.getDepartmentById(52L))
                                .thenReturn(department);

                mockMvc.perform(get("/departments/{id}", 52)
                                .contentType(MediaType.APPLICATION_JSON))
                                .andDo(print())
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$.departmentName").value(department.getDepartmentName()));

        }

        @Test
        void testGetDepartmentByName() throws Exception {

                Mockito.when(departmentService.getDepartmentByName("cs")).thenReturn(department);

                mockMvc.perform(get("/departments/name/{departmentName}", "cs")
                                .contentType(MediaType.APPLICATION_JSON))
                                .andDo(print())
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$.departmentAddress").value(department.getDepartmentAddress()));

        }

        @Test

        void testGetDepartmentByNameAndCode() throws Exception {
                Mockito.when(departmentService.getDepartmentByNameAndCode("cs", "cs-15")).thenReturn(department);

                mockMvc.perform(get("/departments/nameAndCode/cs/cs-15").contentType(MediaType.APPLICATION_JSON))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$.departmentName").value(department.getDepartmentName()));

        }

        @Test
        void testSaveDepartment() throws Exception {
                Department inputDepartment = Department.builder().departmentId(1L).departmentName("CS")
                                .departmentAddress("pune").departmentCode("CS-15").build();

                Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);

                mockMvc.perform(post("/departments").contentType(MediaType.APPLICATION_JSON)
                                .content("{\n" + "\t\"departmentName\":\"cs\",\n" +
                                                "\t\"departmentAddress\":\"pune\",\n" +
                                                "\t\"departmentCode\":\"cs-15\"\n" +
                                                "}"))
                                .andExpect(status().isOk());

        }
}
