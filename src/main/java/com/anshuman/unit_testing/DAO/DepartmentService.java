package com.anshuman.unit_testing.DAO;

import com.anshuman.unit_testing.DTO.DepartmentRequest;
import com.anshuman.unit_testing.Entity.Department;
import com.anshuman.unit_testing.Error.DepartmentAlreadyExists;
import com.anshuman.unit_testing.Error.DepartmentNotFoundException;
import com.anshuman.unit_testing.Error.DepartmentNotSaved;

public interface DepartmentService {
    Department getDepartmentById(String deptId) throws DepartmentNotFoundException;
    Department saveDepartment(DepartmentRequest departmentRequest) throws DepartmentNotSaved, DepartmentAlreadyExists;
}
