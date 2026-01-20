package com.yt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yt.entity.Project;

public interface IProjectRepository extends JpaRepository<Project,Integer> 
{

}
