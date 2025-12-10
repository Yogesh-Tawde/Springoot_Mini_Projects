package com.yt.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class ActorInfo 
{
	
	@Id
	private Integer aid;
	private String aname;
	private String category;
	private Double fee;

}
