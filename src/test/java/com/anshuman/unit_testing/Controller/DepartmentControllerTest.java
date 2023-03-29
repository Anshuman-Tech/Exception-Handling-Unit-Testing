package com.anshuman.unit_testing.Controller;

import com.anshuman.unit_testing.DAO.DepartmentService;
import com.anshuman.unit_testing.DTO.DepartmentRequest;
import com.anshuman.unit_testing.Entity.Department;
import com.anshuman.unit_testing.Error.DepartmentAlreadyExists;
import com.anshuman.unit_testing.Error.DepartmentNotFoundException;
import com.anshuman.unit_testing.Error.DepartmentNotSaved;
import com.jayway.jsonpath.JsonPath;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.print.attribute.standard.Media;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department = new Department();
        department.setDepartmentId("Dept111");
        department.setDepartmentName("TestDepartment");
        department.setCapacity(1000);
    }

    @Test
    void getDepartmentById() throws Exception {
        String deptId = "Dept1";
        Mockito.when(departmentService.getDepartmentById(deptId)).thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.get("/department/get/Dept1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentName").value(department.getDepartmentName()));
    }

    @Test
    void saveDepartment() throws Exception {
        DepartmentRequest inputDepartmentRequest = new DepartmentRequest("Dept111","TestDepartment",1000);
        Mockito.when(departmentService.saveDepartment(inputDepartmentRequest)).thenReturn(department);

        //Create an object of JSON type.
        JSONObject obj = new JSONObject();
        obj.put("departmentId","Dept111");
        obj.put("departmentName","TestDepartment");
        obj.put("capacity",1000);

        mockMvc.perform(MockMvcRequestBuilders.post("/department/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.valueOf(obj)))
                        .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}