package com.yt.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yt.model.Student;
import com.yt.repository.IStudentRepository;

@Service
public class StudentMgmtServiceImpl implements IStudentMgmtService 
{
	
	@Autowired
	private IStudentRepository studRepo;

	@Override
	public List<Student> getAllStudent() 
	{
		return studRepo.findAll();
	}

	@Override
	public String registerStudent(Student stud) 
	{
		Student s = new Student();
		BeanUtils.copyProperties(stud, s);
		s.setCreatedBy("user.name");
		Integer sid = studRepo.save(s).getSid();
		return "Student with id: "+sid+" register succesfully";
	}

	@Override
	public Student getStudentById(int id) 
	{
		Student stud = studRepo.findById(id).orElseThrow(()->new IllegalArgumentException());
		return stud;
	}

	@Override
	public String updateStudent(Student stud) 
	{
		return  "Student Updated with Id Value "+studRepo.save(stud).getSid();
	}

	@Override
	public String deleteStudentById(int id) 
	{
		studRepo.deleteById(id);
	    return "Student with id : "+id+" deleted successfully";
	}
	
	
	
	
	
	
	
	
	
	

}
