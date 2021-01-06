package com.example.ChatApp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.example.ChatApp.model.User;

@Controller
public class GreetingController {


	List<String> usernames=new ArrayList<String>();
  @MessageMapping("/message") ////'topic' is prefix no need add topic before it (as api url is changed then)and we can't add anything as message is coming to topic/hello
  @SendTo("/topic/usermessage")
  public User greeting(User user) throws Exception {
    return user;
  }
  


}