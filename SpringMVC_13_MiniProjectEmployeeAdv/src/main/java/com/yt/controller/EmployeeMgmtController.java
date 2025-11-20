package com.yt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yt.model.Employee;
import com.yt.service.IEmployeeMgmtService;

@Controller
public class EmployeeMgmtController 
{
	
	@Autowired
	private IEmployeeMgmtService service;
	
	@GetMapping("/")
	public String showHomePage() 
	{
		return "home";
	}
	
	@GetMapping("/emp_report")
	public String showAllEmployeesReport(Map<String,Object> map)
	{
		
		List<Employee> itEmp = service.getAllEmployees();
		map.put("empList", itEmp);
		return "show_emp_report";
	}
	
	@GetMapping("/add_emp")
	public String showFormForRegisterEmployee(@ModelAttribute("emp") Employee employee)
	{
		return "register_employee";	
	}
	
	@PostMapping("/add_emp")
	public String saveEmployee(@ModelAttribute("emp") Employee emp,Map<String,Object> map)
	{
		String msg = service.registerEmployee(emp);
		List<Employee> itEmps = service.getAllEmployees();
		map.put("resultMsg", msg);
		map.put("empList", itEmps);
		
		return "redirect:emp_report";
		
	}
	
	@GetMapping("/edit_emp")
	public String showEditEmployeeForm(@RequestParam("id") int id,@ModelAttribute("emp") Employee emp )
	{
		//service
		Employee emp1 = service.getEmployeeById(id);
		//copy data
		BeanUtils.copyProperties(emp1, emp);
		return "update_employee";
	}
	
	@PostMapping("/edit_emp")
	public String editEmployee(RedirectAttributes attrs,@ModelAttribute("emp") Employee emp)
	{
		
		//user service
		String msg = service.updateEmployee(emp);
		//add result messege as flash attibute
		attrs.addFlashAttribute("resultMsg",msg);
		//redirect
		return "redirect:emp_report";
	}
	
	@GetMapping("/delete_emp")
	public String deleteEmployee(RedirectAttributes attrs,@RequestParam int id)
	{
		
		String msg = service.deleteEmployeeById(id);
		attrs.addFlashAttribute("resultMsg", msg);
		return "redirect:emp_report";
	}
	
}
