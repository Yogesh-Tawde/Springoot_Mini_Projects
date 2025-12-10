package com.yt.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.yt.document.ActorInfo;

public interface IActorRepo  extends ReactiveMongoRepository<ActorInfo, Integer>
{

}
