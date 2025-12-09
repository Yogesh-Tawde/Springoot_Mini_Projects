package com.yt.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yt.model.Turist;
import com.yt.repository.ITuristRepository;

import lombok.NonNull;


@Service
public class TuristServiceImpl implements ITuristService
{
	@Autowired
	private ITuristRepository turRepo;
	
	
	@Override
	public String registerTurist(Turist turist)
	{	
		
		Integer tid = turRepo.save(turist).getTid();
		return "Turist registered successfully having regitration id: "+tid;
	}


	@Override
	public List<Turist> shoAllTurist() 
	{
		List<Turist> turistList = turRepo.findAll();
		turistList.sort((l1,l2)->l1.getTid().compareTo(l2.getTid()));
		return turistList;
	}


	@Override
	public String getTuristById(Integer id)
	{
		return "Details of Turist is with id "+ id+" "+turRepo.findById(id).orElseThrow();
		
	}
	
	@Override
	public String updateTurist(Turist turist) {
		Optional<Turist> tid = turRepo.findById(turist.getTid());
		
		if(tid.isPresent())
		{
			Integer turId = turRepo.save(turist).getTid();
			return turId+" Updated Successfully!";
		}
	   return tid+" turist not found";
	}
   
	
	@Override
	public String updateTuristById(Integer id, Double hikePercentage)
	{
		Optional<Turist> byId = turRepo.findById(id);
		if(byId.isPresent())
		{
			Turist turist = byId.get();
			Double budget = turist.getBudget();
			Double newBuget = budget+(budget*hikePercentage/100.0);
			
			turist.setBudget(newBuget);
		    Turist save = turRepo.save(turist);
		    return "The budget is hiked and new budget is:  "+ newBuget;
		}
		else
		{
			return id+" Not found";
		}
		
	}
	
	

	@Override
	public String deleteTurist(Integer id) 
	{
		Optional<Turist> byId = turRepo.findById(id);
		if(byId.isPresent())
		{
			turRepo.deleteById(id);
			return id+" Turist deleted Successfully";
		}
		else
		{
			return "Turist Not Found";
		}
	}





	
	
	
	

}
