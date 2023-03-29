package com.anshuman.unit_testing.Entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Department {

    @Id
    private String departmentId;
    @Column(unique = true,nullable = false)
    private String departmentName;
    private int capacity;

    public Department(){

    }
    public Department(String departmentId,String departmentName, int capacity){
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.capacity = capacity;
    }

    public String getDepartmentId(){
        return departmentId;
    }
    public void setDepartmentId(String departmentId){
        this.departmentId = departmentId;
    }
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName){
        this.departmentName = departmentName;
    }
    public int getCapacity(){
        return capacity;
    }
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId='" + departmentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
