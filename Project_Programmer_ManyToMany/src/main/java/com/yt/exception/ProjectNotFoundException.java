package com.yt.exception;



@SuppressWarnings("serial")
public class ProjectNotFoundException extends RuntimeException 
{



	public ProjectNotFoundException()
	{
		super();
	}
	
	
	public String getMessege(String messege)
	{
		return messege;
	}

}
