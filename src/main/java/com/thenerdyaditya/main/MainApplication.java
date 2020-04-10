package com.thenerdyaditya.main;

import com.thenerdyaditya.dao.EmployeeDAO;
import com.thenerdyaditya.domain.Employee;
import com.thenerdyaditya.service.EmployeeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MainApplication {
    public static void main(String[] args){
        //General Java
//        EmployeeService empService = new EmployeeService();

        //Setter Injection
//        EmployeeDAO empDAO = new EmployeeDAO();
//        EmployeeService empService = new EmployeeService();
//        empService.setEmpDAO(empDAO);

        //Constructor Injection
//        EmployeeDAO empDAO = new EmployeeDAO();
//        EmployeeService empService = new EmployeeService(empDAO);

        //Spring Setter and Constructor Injection
        ApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeService empService = container.getBean(EmployeeService.class);

        Employee emp1 = new Employee("1", "Test1", "Manager", 1000);
        Employee emp2 = new Employee("2", "Test2", "Manager", 1000);
        Employee emp3 = new Employee("3", "Test3", "Manager", 1000);
        Employee emp4 = new Employee("4", "Test4", "Manager", 1000);
        Employee emp5 = new Employee("5", "Test5", "Manager", 1000);

        empService.addNewEmployee(emp1);
        empService.addNewEmployee(emp2);
        empService.addNewEmployee(emp3);
        empService.addNewEmployee(emp4);
        empService.addNewEmployee(emp5);

        List<Employee> employees = empService.getEmployees();

        for(Employee employee: employees){
            System.out.println(employee.getName());
        }
    }
}
