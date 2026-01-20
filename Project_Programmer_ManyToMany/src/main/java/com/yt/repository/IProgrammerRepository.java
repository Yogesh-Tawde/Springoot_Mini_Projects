package com.yt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yt.entity.Programmer;

public interface IProgrammerRepository extends JpaRepository<Programmer,Integer> 
{

}
