package com.anshuman.unit_testing.Repository;

import com.anshuman.unit_testing.Entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //Instructs Spring boot to work
// with default datasource that is database.
class DepartmentRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = new Department();
        department.setDepartmentId("Dept123");
        department.setDepartmentName("TestDepartment");
        department.setCapacity(1000);

        testEntityManager.persist(department);
    }

    @Test
    public void whenFindByIdThenReturnDepartment(){
         Department department = departmentRepository.findById("Dept123").get();
         assertEquals(department.getDepartmentName(),"TestDepartment");
    }
}