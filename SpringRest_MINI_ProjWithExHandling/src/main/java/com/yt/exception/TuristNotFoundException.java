package com.yt.exception;
@SuppressWarnings("serial")
public class TuristNotFoundException extends RuntimeException 
{

    public TuristNotFoundException() 
    {
        super();
    }

    public TuristNotFoundException(String message) 
    {
        super(message);
    }
}

