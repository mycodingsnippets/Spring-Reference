package com.thenerdyaditya.dao;

import com.thenerdyaditya.domain.Employee;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeDAO {

    public void addNewEmployee(Employee employee);
    public List<Employee> getAllEmployees();

}
