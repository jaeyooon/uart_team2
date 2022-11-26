package com.multi.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.multi.dto.ChatbotDTO;
import com.multi.frame.ChatBotUtil;

@Controller
public class ChatbotController { //채팅요청 처리
	
	@Autowired
	SimpMessagingTemplate template; //메시지 보내는 역할
	
	@MessageMapping("/uart_chatbot")
	public void uart_chatbot(ChatbotDTO uart, SimpMessageHeaderAccessor headerAccessor) throws IOException {
		String id=uart.getChatbotid();
		uart.setContent2(" ");
		String result=ChatBotUtil.chat(uart.getContent1());
		uart.setContent1(result);
		template.convertAndSend("/send/"+id, uart);
		
	}

}
