package com.zaurdadasov.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.zaurdadasov.model.ChatMessage;

@Service
public class ChatMessageServiceImpl  {
	
	@Autowired
	private SimpMessagingTemplate messagingTemplate;
	
	public void handleIncomingMessage(ChatMessage message) {
		     messagingTemplate.convertAndSend("/topic/kitchen",message);
		
	}

}
