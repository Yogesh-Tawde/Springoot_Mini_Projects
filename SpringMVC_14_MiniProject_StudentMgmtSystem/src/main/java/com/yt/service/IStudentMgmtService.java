package com.yt.service;

import java.util.List;

import com.yt.model.Student;

public interface IStudentMgmtService 
{
	public List<Student> getAllStudent();
	public String registerStudent(Student stud);
	public Student getStudentById(int id);
	public String updateStudent(Student stud);
	public String deleteStudentById(int id);

}
