package com.yt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yt.model.Turist;

public interface ITuristRepository extends JpaRepository<Turist,Integer>
{

}
