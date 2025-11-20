package com.yt.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yt.model.Employee;
import com.yt.repository.IEmployeeRepository;

@Service
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService 
{
	@Autowired
	private IEmployeeRepository empRepo;

	@Override
	public List<Employee> getAllEmployees()
	{
		return empRepo.findAll();
	}

	@Override
	public String registerEmployee(Employee emp)
	{
		Employee e = new Employee();
		BeanUtils.copyProperties(emp, e);
		e.setCreatedBy("user.name");
		Integer eid = empRepo.save(e).getEid();
		return eid+"Employee Registered Successfully";
	}

	
	@Override
	public Employee getEmployeeById(int id) 
	{
		Employee emp = empRepo.findById(id).orElseThrow(()->new IllegalArgumentException());
		return emp;
	}

	@Override
	public String updateEmployee(Employee emp) 
	{
		return "Employee Updated with Id Value:"+empRepo.save(emp).getEid();
	}

	@Override
	public String deleteEmployeeById(int id) 
	{
		empRepo.deleteById(id);
		
		return id+" id Employee deleted successfully";
	}
	
	
	

}
