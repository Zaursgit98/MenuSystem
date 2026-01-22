package com.zaurdadasov.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ChatMessage<T> {
	
	 private String id;
	
	 private String sender;
	 
	 private T message;
	
	 private LocalDateTime createAtTime;
	 
	 

}
