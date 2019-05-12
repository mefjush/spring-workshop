package pl.sda.kantor.chat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.RestTemplateXhrTransport;
import org.springframework.web.socket.sockjs.client.SockJsClient;

import java.util.Collections;

@Configuration
public class ChatConfiguration {

    private static final String DEFAULT_URL = "ws://spring-ws-chat.herokuapp.com/ws";

    @Bean(destroyMethod = "disconnect")
    ChatConnection chatConnection(ChatBot chatBot) {
        SockJsClient sockJsClient = new SockJsClient(Collections.singletonList(new RestTemplateXhrTransport()));
        WebSocketStompClient stompClient = new WebSocketStompClient(sockJsClient);
        stompClient.setMessageConverter(new MappingJackson2MessageConverter());
        ChatConnection chatConnection = new ChatConnection(stompClient, chatBot);
//        chatConnection.connect(DEFAULT_URL);
        return chatConnection;
    }
}
