package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;

public interface IEmployeeService {

	public Employee saveEmployee(Employee employee);

	public String updateEmpolyee(Employee employee);

	public String deleteEmpolyee(Long empId);

	public Employee getEmployee(Long empId);

	public List<Employee> getAllEmployees();

	public List<Employee> saveEmployees(List<Employee> saveEmps);

}
