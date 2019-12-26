package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.IEmployeeService;

@RestController
@RequestMapping("/employee/management")
public class EmployeeController {

	@Autowired
	IEmployeeService empService;

	@PostMapping
	public Employee saveEmployee(@RequestBody Employee emp) {
		return empService.saveEmployee(emp);
	}

	@GetMapping
	public List<Employee> getAllEmployee() {
		return empService.getAllEmployees();
	}

	@PutMapping
	public String updateEmployee(@RequestBody Employee emp) {
		return empService.updateEmpolyee(emp);
	}

	@GetMapping("/{empId}")
	public Employee getEmployee(@PathVariable Long empId) {
		return empService.getEmployee(empId);
	}

	@DeleteMapping(value = "/{empId}")
	public String deleteEmployee(@PathVariable Long empId) {
		return empService.deleteEmpolyee(empId);
	}

	@PostMapping(value = "/bulk-save")
	public List<Employee> saveBulkEmployee(@RequestBody List<Employee> emps) {
		return empService.saveEmployees(emps);
	}
}
