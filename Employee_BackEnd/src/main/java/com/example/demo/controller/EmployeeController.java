package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.services.EmployeeService;

@RestController

@RequestMapping("/employee")
@CrossOrigin(origins="*")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@CrossOrigin(origins="http://localhost:3000")
	@PostMapping("/save")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee> (employeeService.createEmployee(employee),HttpStatus.CREATED); 
	}
	

	@CrossOrigin(origins="http://localhost:3000")
	@GetMapping("/getAll")
	public List<Employee> getAllEmployee(){
		return employeeService.getAllEmployees();
	}

	@CrossOrigin(origins="http://localhost:3000")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") long id) {
		employeeService.deleteEmployeeById(id);
		return new ResponseEntity<String>("Deleted", HttpStatus.OK);
		
	}
	
	@CrossOrigin(origins="http://localhost:3000")
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee>updateEmployee(@RequestBody Employee employee, @PathVariable("id")long id){
		return new ResponseEntity<Employee>(employeeService.updateEmployee(id, employee),HttpStatus.OK);
	}
	
	@CrossOrigin(origins="http://localhost:3000")
	@GetMapping("/getEmployeeById/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id){
		return new ResponseEntity<Employee> (employeeService.getEmployeeById(id),HttpStatus.OK);
	}
	
	
}
