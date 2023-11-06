package com.sk26.springboot.tutorial.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.sk26.springboot.tutorial.entity.Department;

@DataJpaTest
public class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    private Logger logger = LoggerFactory.getLogger(DepartmentRepositoryTest.class);

    @BeforeEach
    void setUp() {
        Department department = Department.builder().departmentId(1L).departmentName("CS").departmentAddress("Pune")
                .departmentCode("CS-15").build();

        testEntityManager.persist(department);
    }

    @Test
    void testFindByDepartmentNameAndDepartmentCodeIgnoreCase() {
        Department department = departmentRepository.findByDepartmentNameAndDepartmentCodeIgnoreCase("CS", "Cs-15");

        logger.info(department.toString());

        assertEquals("CS", department.getDepartmentName());
        assertNotEquals(2, department.getDepartmentId());
    }

    @Test
    @Disabled
    void testFindByDepartmentNameIgnoreCase() {

    }
}
