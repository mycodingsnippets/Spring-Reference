package com.thenerdyaditya.service;

import com.thenerdyaditya.dao.EmployeeDAO;
import com.thenerdyaditya.dao.EmployeeDAOUsingJDBC;
import com.thenerdyaditya.domain.Employee;

import java.util.List;

public class EmployeeService {

    //General Java
//    EmployeeDAO empDAO = new EmployeeDAO();

    EmployeeDAO empDAO;

    //Setter Injection
    public void setEmpDAO(EmployeeDAO empDAO){
        this.empDAO = empDAO;
    }

    //Constructor Injection
//    public EmployeeService(){
//
//    }
//    public EmployeeService(EmployeeDAO empDAO){
//        this.empDAO = empDAO;
//    }


    public void addNewEmployee(Employee emp){
        empDAO.addNewEmployee(emp);
    }

    public List<Employee> getEmployees(){
        return empDAO.getAllEmployees();
    }
}

