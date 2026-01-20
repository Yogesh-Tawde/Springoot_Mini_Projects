package com.yt.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yt.entity.Programmer;
import com.yt.entity.Project;
import com.yt.repository.IProgrammerRepository;
import com.yt.repository.IProjectRepository;
import jakarta.transaction.Transactional;


@Service
@Transactional
public class MTMAsscociationServiceImpl implements IService 
{

	
	@Autowired
	private IProgrammerRepository programmerRepo;
	
	
	@Autowired
	private IProjectRepository projectRepo;


  
	
	@Override
	public String saveDataUsingProject(Project project) 
	{
		projectRepo.save(project);
		return "Data savved successfully! ";
	}


	@Override
	public List<Project> fetchAllDataUsingProject() 
	{
		
		List<Project> list = projectRepo.findAll();
		
		list.forEach(proj->
		{
			System.out.println(proj);
			Set<Programmer> programmers = proj.getProgrammerInfo();
			
			programmers.forEach(prog->
			{
				
				System.out.println(prog);
			});
		});
		
		return list;
	}

	

	@Override
	public String deleteAllDataByUsingProjectId(Integer id) 
	{
		
		Optional<Project> byId = projectRepo.findById(id);
		
		if(byId.isPresent())
		{
			projectRepo.deleteById(id);
			return "Data Deleted";
		}
		
		return "No Id found";
	}


	@Override
	public String updateDataUsingProjectId(Integer id, Project project) 
	{
		Optional<Project> byId = projectRepo.findById(id);
		
		if(byId.isPresent())
		{
			Project p = byId.get();
			p.setProjectName(project.getProjectName());
			p.setProjComp(project.getProjComp());
			projectRepo.save(p);
			
			return "Data updated successfully!";
		}
		
		return "Invlid Id";
	}


	
	@Override
	public String saveDataUsingProgrammer(Programmer programmer) 
	{
		 programmerRepo.save(programmer);
		return "Data saved by using programmer";
	}

	
	
	
	
	
	
	
	
	

}
