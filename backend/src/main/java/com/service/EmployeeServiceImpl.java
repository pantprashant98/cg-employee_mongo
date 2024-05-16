package com.service;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.UncategorizedMongoDbException;
import org.springframework.stereotype.Service;

import com.error.UserAlreadyExistsException;
import com.model.Employee;
import com.repos.EmployeeRepository;

@Service
public class EmployeeServiceImpl  implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void createEmployee(Employee employee) {
        boolean exists = employeeRepository.existsByEmployeeId(employee.getEmployeeId());

        if (exists) {
			// If user exists, throw a custom exception to handle this specific error
			// scenario
			throw new UserAlreadyExistsException("User with Id " + employee.getEmployeeId() + " already exists.");
		}

        employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> getEmployee(String id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee;
        
    }

    @Override
    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void updateEmployee(Employee employee) {

        // Employee e = employeeRepository.getById(employee.getId());

        Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getId());
    
    if (optionalEmployee.isPresent()) {
        Employee e = optionalEmployee.get();
        e.setEmployeeId(employee.getEmployeeId());
        e.setFirstName(employee.getFirstName());
        e.setLastName(employee.getLastName());
        e.setDateofBirth(employee.getDateofBirth());
        e.setEmailId(employee.getEmailId());
        e.setLast4Ssn(employee.getLast4Ssn());
        employeeRepository.save(e);
    } else {
        // Handle the case when the employee with the given ID is not found
        throw new UncategorizedMongoDbException("Employee with ID " + employee.getId() + " not found", null);
    }
}

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
}
