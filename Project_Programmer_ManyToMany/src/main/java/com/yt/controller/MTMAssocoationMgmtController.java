package com.yt.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yt.entity.Programmer;
import com.yt.entity.Project;
import com.yt.service.IService;

@RestController
@RequestMapping("/MTM")
public class MTMAssocoationMgmtController 
{
	
	
	@Autowired
	private IService service;
	
	
	@PostMapping("/save")
	public ResponseEntity<String> saveDataUsingProject(@RequestBody Project project)
	{
		
		String resultMsg = service.saveDataUsingProject(project);
		return new ResponseEntity<String>(resultMsg,HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/get")
	public ResponseEntity<?> getAllDataUsingProject()
	{
		
		List<Project>  list = service.fetchAllDataUsingProject();
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	
	
	@PostMapping("/update/{id}")
	public ResponseEntity<String> updateDataUsingProjectId(@PathVariable("projectId") Integer id,@RequestBody Project project)
	{
		
		String resultMsg = service.updateDataUsingProjectId(id, project);
		return new ResponseEntity<String>(resultMsg,HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteAllDataUsingProjectId(Integer id)
	{
		String resultMsg = service.deleteAllDataByUsingProjectId(id);
		return new ResponseEntity<String>(resultMsg,HttpStatus.OK); 
	}
	
	
	
	@PostMapping("/add")
	public ResponseEntity<String> saveDataUsingProgrammer(@RequestBody Programmer programmer)
	{
		String resultMsg = service.saveDataUsingProgrammer(programmer);
		return new ResponseEntity<String>(resultMsg,HttpStatus.CREATED);
	}

}
