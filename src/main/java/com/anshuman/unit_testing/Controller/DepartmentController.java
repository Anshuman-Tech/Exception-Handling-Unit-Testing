package com.anshuman.unit_testing.Controller;

import com.anshuman.unit_testing.DAO.DepartmentService;
import com.anshuman.unit_testing.DTO.DepartmentRequest;
import com.anshuman.unit_testing.Entity.Department;
import com.anshuman.unit_testing.Error.DepartmentAlreadyExists;
import com.anshuman.unit_testing.Error.DepartmentNotFoundException;
import com.anshuman.unit_testing.Error.DepartmentNotSaved;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping("/get/{deptId}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable() String deptId) throws DepartmentNotFoundException {
        Department dept = departmentService.getDepartmentById(deptId);
        if(dept!=null){
            return new ResponseEntity(dept,HttpStatus.OK);
        }
        else{
            return new ResponseEntity("Department Not found",HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/save")
    public ResponseEntity<Department> saveDepartment(@RequestBody DepartmentRequest departmentRequest) throws DepartmentNotSaved, DepartmentAlreadyExists {
        Department department = departmentService.saveDepartment(departmentRequest);
        if(department!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(department);
        }
        else{
            return new ResponseEntity("Department not saved",HttpStatus.BAD_REQUEST);
        }
    }
}
