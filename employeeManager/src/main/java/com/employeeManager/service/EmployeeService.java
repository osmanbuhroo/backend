package com.employeeManager.service;

import com.employeeManager.entity.Employee;
import com.employeeManager.exception.UserNotFoundException;

import java.util.List;

public interface EmployeeService {


    List<Employee> findAllEmployees();

    Employee findEmployeeById(Long id) throws UserNotFoundException;

    Employee addEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    String  deleteEmployee(Long id);
}
