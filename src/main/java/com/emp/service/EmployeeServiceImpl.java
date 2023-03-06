package com.emp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.emp.model.Employee;
import com.emp.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}

	@Override
	public Optional<Employee> getEmployeeById(int id) {
		
		return employeeRepository.findById(id);
	}

	@Override
	public List<Employee> getAllEmployee() {
	
		return employeeRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));
	}

	@Override
	public Employee updateEmployee(int id, Employee employee) {
		
	    Employee empUpdate=employeeRepository.findById(id).orElseThrow();
	    
	    empUpdate.setFirstName(employee.getFirstName());
	    empUpdate.setLastName(employee.getLastName());
	    empUpdate.setEmail(employee.getEmail());
		return employeeRepository.save(empUpdate);
	}

	@Override
	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
		
	}

}
