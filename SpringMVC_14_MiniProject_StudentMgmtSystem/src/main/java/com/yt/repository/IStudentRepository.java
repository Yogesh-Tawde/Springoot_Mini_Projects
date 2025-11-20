package com.yt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yt.model.Student;

public interface IStudentRepository extends JpaRepository<Student,Integer> 
{

}
