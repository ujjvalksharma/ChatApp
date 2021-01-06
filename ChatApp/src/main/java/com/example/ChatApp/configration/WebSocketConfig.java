package com.example.ChatApp.configration;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/* Below is some documentation about websocket.....
 *A socket is one endpoint of a two-way communication link between two programs running on the network. 
 *A socket is bound to a port number so that the TCP layer can identify the application that
 *data is destined to be sent to. An endpoint is a combination of an IP address and
 *a port number.
 * Endpoint is needed to open connection
 * 
 * So from Spring Websocket's point of view, "/queue" and "/topic" are treated the 
 * same way and are "typical" STOMP destinations - all messages matching those are 
 * forwarded to the messages broker. Now if you're using a full message broker implementation,
 *  those destinations may not have the same meaning and the message broker behavior could be 
 *  different.
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

  @Override
  public void configureMessageBroker(MessageBrokerRegistry config) {
	  /*
	   * to enable a simple memory-based message broker to carry the greeting
	   *  messages back to the client on destinations prefixed with /topic (topic is basically a prefix to send message)
	   */
    config.enableSimpleBroker("/topic"); // send message to client
    /*
     * It also designates the /app prefix for messages that are bound
     *  for methods annotated with @MessageMapping
     */
    config.setApplicationDestinationPrefixes("/app"); // get message from client
  }

  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {
    registry.addEndpoint("/private-chat").withSockJS(); //open/estabalish connection
  }

}
