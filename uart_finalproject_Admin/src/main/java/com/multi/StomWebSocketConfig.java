package com.multi;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@EnableWebSocketMessageBroker
@Configuration
public class StomWebSocketConfig implements WebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) { //웹소켓 서버들(end point)
		registry.addEndpoint("/chatbot").setAllowedOrigins("http://101.101.219.170", "http://101.101.219.170/admin/chatbot").withSockJS();  //나와의 채팅을 위해, 챗봇기능도 이와같음
	}

	/* 어플리케이션 내부에서 사용할 path를 지정할 수 있음 */
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) { //클라이언트의 endpoint
		registry.enableSimpleBroker("/send","/broadcast");
	}
}