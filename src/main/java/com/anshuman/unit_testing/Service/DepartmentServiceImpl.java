package com.anshuman.unit_testing.Service;

import com.anshuman.unit_testing.DAO.DepartmentService;
import com.anshuman.unit_testing.DTO.DepartmentRequest;
import com.anshuman.unit_testing.Entity.Department;
import com.anshuman.unit_testing.Error.DepartmentAlreadyExists;
import com.anshuman.unit_testing.Error.DepartmentNotFoundException;
import com.anshuman.unit_testing.Error.DepartmentNotSaved;
import com.anshuman.unit_testing.Repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department getDepartmentById(String deptId) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(deptId);
        if(department.isPresent()){
            return department.get();
        }
        else{
            throw new DepartmentNotFoundException("Department not found! Check the department Id");
        }
    }

    @Override
    public Department saveDepartment(DepartmentRequest departmentRequest) throws DepartmentNotSaved,DepartmentAlreadyExists{

        Department department = new Department(departmentRequest.getDepartmentId(),
                departmentRequest.getDepartmentName(),departmentRequest.getCapacity());

        Optional<Department> exitingDepartment = departmentRepository.findById(departmentRequest.getDepartmentId());
        if(exitingDepartment.isPresent()){
            throw new DepartmentAlreadyExists("Department Already exists");
        }
        else {
            Department savedDepartment = departmentRepository.save(department);

            //Check that the department is saved or not.
            Optional<Department> newSavedDepartment = departmentRepository.findById(departmentRequest.getDepartmentId());
            if (!newSavedDepartment.isPresent()) {
                throw new DepartmentNotSaved("Department Not Saved! Check the format");
            } else {
                return newSavedDepartment.get();
            }
        }
    }
}
