package com.thenerdyaditya.dao;

import com.thenerdyaditya.domain.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOUsingJDBC implements EmployeeDAO {

    public EmployeeDAOUsingJDBC(){
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            CreateEmployeeTable();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    private static void CreateEmployeeTable(){
        try{
            Connection con = null;

            try{
                con = DriverManager.getConnection("jdbc:hsqldb:file:database.dat;shutdown=true", "sa", "");
                Statement stmt = con.createStatement();
                stmt.executeUpdate("create table Employee(empId VARCHAR(50), name VARCHAR(50), designation VARCHAR(50), salary VARCHAR(50))");
                System.out.println("Create New Table Employee");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if(con != null)
                    con.close();
            }
        }catch (SQLException e){
            System.out.println("Employee table has already been created...");
        }
    }

    public void addNewEmployee(Employee employee){
        try{
            Connection con = null;
            PreparedStatement insertEmployee = null;
            try{
                con = DriverManager.getConnection("jdbc:hsqldb:file:database.dat;shutdown=true", "sa", "");
                insertEmployee = con.prepareStatement("insert into Employee(empid, name, designation) values (?, ?, ?)");
                insertEmployee.setString(1, employee.getEmpId());
                insertEmployee.setString(2, employee.getName());
                insertEmployee.setString(3, employee.getDesignation());
                insertEmployee.executeUpdate();
                System.out.println("Created New Employee");
            }finally {
                if(con != null ){
                    con.close();
                }
            }
        }catch (SQLException e){
            System.out.println("Exception Occured");
        }
    }

    public List<Employee> getAllEmployees(){
        List<Employee> results = new ArrayList<Employee>();

        try{
            Connection con = null;
            PreparedStatement retrieveBooks = null;
            ResultSet rs = null;
            try{
                con = DriverManager.getConnection("jdbc:hsqldb:file:database.dat;shutdown=true", "sa", "");
                retrieveBooks = con.prepareStatement("select * from Employee");
                rs = retrieveBooks.executeQuery();
                while (rs.next()){
                    String empId = rs.getString(1);
                    String name = rs.getString(2);
                    String designation = rs.getString(3);
                    double salary = 0;
                    Employee nextBook = new Employee(empId, name, designation, salary);
                    results.add(nextBook);
                }
            }finally {
                if(rs != null){
                    rs.close();
                }
                if(con != null){
                    con.close();
                }
            }
        }catch (SQLException e){
            System.out.println("Exception occured");
        }
        return results;
    }
}
