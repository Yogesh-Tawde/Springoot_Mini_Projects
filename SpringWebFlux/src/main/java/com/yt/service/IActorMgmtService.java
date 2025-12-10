package com.yt.service;

import com.yt.document.ActorInfo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface IActorMgmtService 
{
	
	public Mono<ActorInfo> save(ActorInfo info);
	public Flux<ActorInfo> showAllActors();
	public Mono<ActorInfo> showActorById(Integer id);
	public Mono<Void> deleteActorById(Integer id);
	public Mono<ActorInfo> updateActor(ActorInfo actor);

}
