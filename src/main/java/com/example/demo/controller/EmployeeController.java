package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public Iterable<Employee> getEmployee() {
		return employeeRepository.findAll();
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.POST, consumes = "application/json")
	public Employee createEmployee(@RequestBody Employee employee) {
		employee = employeeRepository.save(employee);
		return employee;
	}
}
