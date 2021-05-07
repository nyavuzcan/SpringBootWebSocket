package com.example.springbootwebsocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
@CrossOrigin
public class WsConfig implements WebSocketMessageBrokerConfigurer {
//Clientların istek atıp connection kurdukları path.
  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {
    registry.addEndpoint("/chat").setAllowedOriginPatterns("*").withSockJS();
  }

  //Mesajın dinleneyeceği path.
  @Override
  public void configureMessageBroker(MessageBrokerRegistry registry) {
    registry.enableSimpleBroker("/topic");
  }
}