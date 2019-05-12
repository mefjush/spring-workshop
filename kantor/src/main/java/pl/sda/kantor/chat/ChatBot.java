package pl.sda.kantor.chat;

import org.springframework.stereotype.Service;

@Service
public class ChatBot {

    public String replyUserMessage(String user, String message) {
        if (message.startsWith("?eur")) {
            //TODO popraw i przetestuj na stronie http://spring-ws-chat.herokuapp.com/
            //TODO ?toEur 100PLN
            return "1 EUR = ??? PLN";
        }
        return "";
    }

    public String getBotName() {
        return Hostname.getHostname() + "_bot";
    }
}
