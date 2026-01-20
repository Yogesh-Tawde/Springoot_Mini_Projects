package com.yt.service;

import java.util.List;

import com.yt.entity.Programmer;
import com.yt.entity.Project;

public interface IService 
{
	
	public String saveDataUsingProject(Project project);
	public List<Project> fetchAllDataUsingProject();
	public String updateDataUsingProjectId(Integer id,Project project);
	public String deleteAllDataByUsingProjectId(Integer id);
	
	public String saveDataUsingProgrammer(Programmer programmer);

}
