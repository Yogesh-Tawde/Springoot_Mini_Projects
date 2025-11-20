package com.yt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yt.model.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer>
{

}
