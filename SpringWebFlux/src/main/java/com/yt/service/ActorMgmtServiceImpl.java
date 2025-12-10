package com.yt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yt.document.ActorInfo;
import com.yt.repository.IActorRepo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ActorMgmtServiceImpl implements IActorMgmtService
{

	@Autowired
	private IActorRepo actRepo;
	
	
	@Override
	public Mono<ActorInfo> save(ActorInfo info) 
	{
		Mono<ActorInfo> savedDoc = actRepo.save(info);
		return savedDoc;
	}

	
	@Override
	public Flux<ActorInfo> showAllActors() 
	{
		return actRepo.findAll().switchIfEmpty(Flux.empty());
	}


	@Override
	public Mono<ActorInfo> showActorById(Integer id) 
	{	
		try
		{
			Thread.sleep(40000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		return actRepo.findById(id).switchIfEmpty(Mono.empty());
	}


	@Override
	public Mono<Void> deleteActorById(Integer id) 
	{
		Mono<ActorInfo> mono = actRepo.findById(id);
		
		return mono.flatMap(obj->
		{
			return actRepo.deleteById(id).then();
		})
		.onErrorResume(e->{
			return Mono.error(new RuntimeException("ActorInfo document not found for deletion",e));
		});
	}


	@Override
	public Mono<ActorInfo> updateActor(ActorInfo actor) 
	{
	    return actRepo.findById(actor.getAid())
	        .flatMap(existing -> {
	            BeanUtils.copyProperties(actor, existing, "aid"); 
	            return actRepo.save(existing);
	        })
	        .onErrorResume(e -> 
	            Mono.error(new RuntimeException("Actor object did not update", e))
	        );
	}

}
