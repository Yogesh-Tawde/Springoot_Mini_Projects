package com.yt.controller;
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
import com.yt.document.ActorInfo;
import com.yt.service.IActorMgmtService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/actor-api")
public class ActorMgmtController 
{
	
	@Autowired
	private IActorMgmtService service;
	
	@PostMapping("/save")
	public ResponseEntity<Mono<ActorInfo>> saveActor(@RequestBody ActorInfo info)
	{
		Mono<ActorInfo> mono = service.save(info);
		HttpStatus status = HttpStatus.OK;
		return new ResponseEntity<Mono<ActorInfo>>(mono,status);
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<Flux<ActorInfo>> showAllActors()
	{
		Flux<ActorInfo> flux = service.showAllActors();
		return new ResponseEntity<Flux<ActorInfo>>(flux,HttpStatus.OK);
	}
	
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Mono<ActorInfo>> getActorById(@PathVariable Integer id)
	{
		
		Mono<ActorInfo> mono = service.showActorById(id);
		return new ResponseEntity<Mono<ActorInfo>>(mono,HttpStatus.OK );
	}
	
	@GetMapping("delete/{id}")
	public ResponseEntity<String> deleteActor(@PathVariable Integer id)
	{
		 service.deleteActorById(id);
		 return new ResponseEntity<String>("Document deleted ",HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Mono<ActorInfo>> updateActor(@RequestBody ActorInfo info)
	{
		Mono<ActorInfo> mono = service.updateActor(info);
		HttpStatus status = HttpStatus.OK;
		return new ResponseEntity<Mono<ActorInfo>>(mono,status);
	}
}
