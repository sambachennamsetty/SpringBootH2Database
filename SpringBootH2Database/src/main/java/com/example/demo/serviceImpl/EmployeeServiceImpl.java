package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public String updateEmpolyee(Employee employee) {
		return employeeRepository.findById(employee.getId()).map(emp -> {
			emp.setName(employee.getName());
			emp.setSalary(employee.getSalary());
			employeeRepository.save(emp);
			return "Employee updated successfully";
		}).orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

	}

	@Override
	public String deleteEmpolyee(Long empId) {
		return employeeRepository.findById(empId).map(emp -> {
			employeeRepository.deleteById(empId);
			return "Empolyee'" + empId + "' deleted successfully";
		}).orElseThrow(() -> new ResourceNotFoundException("Empolyee '" + empId + "'not found"));

	}

	@Override
	public Employee getEmployee(Long empId) {
		return employeeRepository.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Empolyee '" + empId + "'not found"));
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public List<Employee> saveEmployees(List<Employee> saveEmps) {
		return employeeRepository.saveAll(saveEmps);
	}

}
