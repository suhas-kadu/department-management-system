package com.sk26.springboot.tutorial.service;

import com.sk26.springboot.tutorial.entity.Department;
import com.sk26.springboot.tutorial.error.DepartmentNotException;
import com.sk26.springboot.tutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long departmentId) throws DepartmentNotException {
        Optional<Department> department = departmentRepository.findById(departmentId);

        if (department.isEmpty()) {
            throw new DepartmentNotException("Department not found");
        }

        return department.get();

    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department getDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }

    @Override
    public Department getDepartmentByNameAndCode(String departmentName, String departmentCode) {
        return departmentRepository.findByDepartmentNameAndDepartmentCodeIgnoreCase(departmentName,
                departmentCode);
    }

    @Override
    public Department getDepartmentByNameOrCode(String departmentName, String departmentCode) {
        return departmentRepository.findByDepartmentNameOrDepartmentCodeIgnoreCase(departmentName, departmentCode);
    }

}
