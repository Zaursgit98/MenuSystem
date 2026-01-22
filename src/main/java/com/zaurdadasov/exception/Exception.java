package com.zaurdadasov.exception;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Exception<T> {
     
	private String path;
	
	private String hostName;
	
	private Date createAtTime;
	
    private T message;
}
