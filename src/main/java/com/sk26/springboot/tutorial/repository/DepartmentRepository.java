package com.sk26.springboot.tutorial.repository;

import com.sk26.springboot.tutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findByDepartmentName(String departmentName);

    Department findByDepartmentNameIgnoreCase(String departmentName);

    Department findByDepartmentNameAndDepartmentCode(String departmentName, String departmentCode);

    Department findByDepartmentNameAndDepartmentCodeIgnoreCase(String departmentName, String departmentCode);

    Department findByDepartmentNameOrDepartmentCode(String departmentName, String departmentCode);

    Department findByDepartmentNameOrDepartmentCodeIgnoreCase(String departmentName, String departmentCode);

}
