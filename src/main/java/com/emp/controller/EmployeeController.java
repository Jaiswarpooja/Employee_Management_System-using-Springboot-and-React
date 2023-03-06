package com.emp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.model.Employee;
import com.emp.service.EmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin("*")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("")
    public Employee saveEmployee(@RequestBody Employee employee) {
    	return employeeService.saveEmployee(employee);
    }


	@GetMapping
	public List<Employee> getAllEmployee(){
		return employeeService.getAllEmployee();
	}

	@GetMapping("/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable int id){
		return employeeService.getEmployeeById(id);
	}

	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable int id,@RequestBody Employee employee) {
		return employeeService.updateEmployee(id, employee);
	}

	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable int id) {
		employeeService.deleteEmployee(id);
	}









}
