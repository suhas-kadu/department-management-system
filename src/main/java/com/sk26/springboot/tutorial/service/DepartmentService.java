package com.sk26.springboot.tutorial.service;

import com.sk26.springboot.tutorial.entity.Department;
import com.sk26.springboot.tutorial.error.DepartmentNotException;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> fetchDepartments();

    Department getDepartmentById(Long departmentId) throws DepartmentNotException;

    void deleteDepartmentById(Long departmentId);

    Department getDepartmentByName(String departmentName);

    Department getDepartmentByNameAndCode(String departmentName, String departmentCode);

    Department getDepartmentByNameOrCode(String departmentName, String departmentCode);
}
