package com.yt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yt.model.Turist;
import com.yt.service.ITuristService;

@RestController
@RequestMapping("/turist")
public class TuristMgmtController 
{
	
	@Autowired
	private ITuristService service;
	  
	
	
	@PostMapping("/register")
	public ResponseEntity<String> enrollTurist(@RequestBody Turist turist)
	{
		
			String resultMsg = service.registerTurist(turist);
			HttpStatus status = HttpStatus.CREATED;
			return new ResponseEntity<String>(resultMsg,status);
		
	}
	
	
	
	
	@PostMapping("/fetch")
	public ResponseEntity<?> getAllTursistsDetails()
	{
			List<Turist> tList = service.shoAllTurist();
			return new ResponseEntity<List<Turist>>(tList,HttpStatus.OK);
	}
	
	
	
	
	@GetMapping("/find/{id}")
	public ResponseEntity<String> getTuristById(@PathVariable Integer id)
	{
			String msg = service.getTuristById(id);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	
	@GetMapping("/update/{id}/{percentage}")
	public ResponseEntity<String> updateTuristBudget(@PathVariable("id") Integer id,@PathVariable ("percentage") Double percentage)
	{
			String msg = service.updateTuristById(id, percentage);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	
	@PutMapping("/modify")
	public ResponseEntity<String> modifyTuristData(@RequestBody Turist turist)
	{
		
			String msg = service.updateTurist(turist);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	

	@PostMapping("/delete/{id}")
	public ResponseEntity<String> deleteTuristDetails(@PathVariable Integer id)
	{
		String msg = service.deleteTurist(id);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}

}
