package com.sk26.springboot.tutorial.controller;

import com.sk26.springboot.tutorial.entity.Department;
import com.sk26.springboot.tutorial.error.DepartmentNotException;
import com.sk26.springboot.tutorial.service.DepartmentService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping("departments")
    public List<Department> fetchDepartments() {
        LOGGER.info(departmentService.fetchDepartments().toString());
        return departmentService.fetchDepartments();
    }

    @GetMapping("departments/{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotException {
        return departmentService.getDepartmentById(departmentId);
    }

    @DeleteMapping("departments/{id}")
    public void deleteDepartmentById(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartmentById(departmentId);
    }

    @GetMapping("departments/name/{departmentName}")
    public Department getDepartmentByName(@PathVariable("departmentName") String departmentName) {
        return departmentService.getDepartmentByName(departmentName);
    }

    @GetMapping("departments/nameAndCode/{departmentName}/{departmentCode}")
    public Department getDepartmentByNameAndCode(@PathVariable("departmentName") String departmentName,
            @PathVariable("departmentCode") String departmentCode) {
        return departmentService.getDepartmentByNameAndCode(departmentName, departmentCode);
    }

    @GetMapping(value = { "departments/nameOrCode/{departmentName}", "departments/nameOrCode/{departmentCode}" })
    public Department getDepartmentByNameOrCode(
            @PathVariable(value = "departmentName", required = false) String departmentName,
            @PathVariable(value = "departmentCode", required = false) String departmentCode) {
        return departmentService.getDepartmentByNameOrCode(departmentName, departmentCode);
    }

}
