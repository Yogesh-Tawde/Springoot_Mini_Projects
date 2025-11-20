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

import com.yt.model.Student;
import com.yt.service.IStudentMgmtService;



@Controller
public class StudentMgmtController 
{
	@Autowired	
	private IStudentMgmtService service;
	
	@GetMapping("/")
	public String showHomePage()
	{
		return "home";
	}
    
	@GetMapping("/std_report")
	public String showStudentData(Map<String,Object> map)
	{
		List<Student> studs = service.getAllStudent();
		map.put("studList", studs);
		return "show_std_report";
	}
	
	@GetMapping("add_stud")
	public String showStudentRegistrationForm(@ModelAttribute("stud") Student student)
	{
		return "register_student";
	}
	
	@PostMapping("/add_stud")
	public String saveStudent(RedirectAttributes attrs,@ModelAttribute("stud") Student stud,Map<String,Object> map)
	{
		String msg = service.registerStudent(stud);
		List<Student> studList = service.getAllStudent();
		map.put("resultMsg", msg);
		map.put("studList", studList);
		attrs.addFlashAttribute("resultMsg",msg);
		return "redirect:/std_report";

	}
	
	@GetMapping("/edit_stud")
	public String showEditStudentForm(@RequestParam("id") int id,@ModelAttribute("stud") Student stud)
	{   //get data
		Student stud1 = service.getStudentById(id);
		//copy data
		BeanUtils.copyProperties(stud1, stud);
		return "update_student";
	}
	
	@PostMapping("/edit_stud")
	public String editEmployee(RedirectAttributes attrs, @ModelAttribute("stud") Student student)
	{
		String msg = service.updateStudent(student);
		attrs.addFlashAttribute("resultMsg",msg);
		return "redirect:/std_report";

	}
	
	@GetMapping("/delete_stud")
	public String deleteStudent(RedirectAttributes attrs,@RequestParam int id)
	{
		String msg = service.deleteStudentById(id);
		attrs.addFlashAttribute("resultMsg", msg);
		return "redirect:/std_report";

		
	}
}
