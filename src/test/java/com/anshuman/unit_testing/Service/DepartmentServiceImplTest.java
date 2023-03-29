package com.anshuman.unit_testing.Service;

import com.anshuman.unit_testing.DAO.DepartmentService;
import com.anshuman.unit_testing.Entity.Department;
import com.anshuman.unit_testing.Error.DepartmentNotFoundException;
import com.anshuman.unit_testing.Repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DepartmentServiceImplTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = new Department("Dept123","TestDepartment",100);

        Mockito.when(departmentRepository.findById("Dept123")).thenReturn(Optional.of(department));
    }



    @Test
    //@Disabled //Used to disable a particular Test
    @DisplayName("Get Department by Id")
    void whenValidDepartmentIdThenReturnDepartment() throws DepartmentNotFoundException {
        String departmentId = "Dept123";
        Department found = departmentService.getDepartmentById(departmentId);
        assertEquals(departmentId,found.getDepartmentId());
    }

//    @Test
//    void whenValidDepartmentDetailsThenSaveDepartment() throws DepartmentAlreadyExists, DepartmentNotSaved {
//        Department department = new Department("Dept111","TestDepartment1",1000);
//
//        Optional<Department> existingDepartment = departmentRepository.findById(department.getDepartmentId());
//        given(departmentRepository.findById(department.getDepartmentId()))
//                .willReturn(Optional.of(department));
//
//        org.junit.jupiter.api.Assertions.assertThrows(DepartmentAlreadyExists.class, () -> {
//            departmentRepository.save(department);
//        });
//
//    }
}