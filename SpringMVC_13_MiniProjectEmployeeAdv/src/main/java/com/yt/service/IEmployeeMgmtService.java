package com.yt.service;

import java.util.List;

import com.yt.model.Employee;

public interface IEmployeeMgmtService 
{
	public List<Employee> getAllEmployees();
	public String registerEmployee(Employee emp);
	public Employee getEmployeeById(int id);
	public String updateEmployee(Employee emp);
	public String deleteEmployeeById(int id);

}
