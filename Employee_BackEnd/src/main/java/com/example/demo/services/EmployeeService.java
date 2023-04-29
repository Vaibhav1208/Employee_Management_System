package com.example.demo.services;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeService {
	Employee createEmployee(Employee employee);
	List <Employee> getAllEmployees();
	void deleteEmployeeById(long id);
	Employee updateEmployee(long id, Employee employee);
	Employee getEmployeeById(long id);
}
