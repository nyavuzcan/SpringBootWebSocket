package com.example.springbootwebsocket.controller;

import com.example.springbootwebsocket.WsMessage;
import com.example.springbootwebsocket.entity.ProductEntity;
import com.example.springbootwebsocket.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Controller
@CrossOrigin
@EnableScheduling
public class ChatController {

  @Autowired
  private SimpMessagingTemplate messagingTemplate;
  @Autowired
  private ProductRepository productRepository;

 //WsConfig üzerinde yaptıgımız endpointi dışarı açarak api oluşturmamız gerekmekte.
  //Client ile tam iletişimin belirlendiği kısım.
  @Scheduled(fixedRate = 5000)
  public void chatEndpoint() {
    List<ProductEntity> productEntityList = productRepository.findAllBy();
    WsMessage wsMessage = new WsMessage();
    wsMessage.setMessage(productEntityList.get(0).getProdName());
    wsMessage.setSender("Admin");
    messagingTemplate.convertAndSend("/topic",wsMessage);
  }
}