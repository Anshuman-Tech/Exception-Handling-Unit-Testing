package com.anshuman.unit_testing.DTO;

public class DepartmentRequest {
    private String departmentId;
    private String departmentName;
    private int capacity;

    public DepartmentRequest(){

    }
    public DepartmentRequest(String departmentId,String departmentName, int capacity){
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
