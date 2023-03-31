package com.employeeManager.service;

import com.employeeManager.entity.Employee;
import com.employeeManager.exception.UserNotFoundException;
import com.employeeManager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeeServiceImp implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    Employee employee;
    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findEmployeeById(Long id) throws UserNotFoundException {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    @Override
    public Employee addEmployee(Employee employee) {
      employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee)  {
        return employeeRepository.save(employee);

    }


    @Override
    public String deleteEmployee(Long id) {
        employeeRepository.deleteEmployeeById(id);
        return "Successfully Deleted Employee";

    }
}
