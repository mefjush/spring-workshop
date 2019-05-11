package pl.sda.kantor.chat;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class ChatMessage {

    private final MessageType type;
    private final String content;
    private final String sender;

    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }

    @JsonCreator
    public ChatMessage(
            @JsonProperty("type") MessageType type,
            @JsonProperty("content") String content,
            @JsonProperty("sender") String sender) {
        this.type = type;
        this.content = content;
        this.sender = sender;
    }

    public ChatMessage(String content, String sender) {
        this(MessageType.CHAT, content, sender);
    }

    public ChatMessage(MessageType type, String sender) {
        this(type, null, sender);
    }

    public MessageType getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public String getSender() {
        return sender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatMessage that = (ChatMessage) o;
        return type == that.type &&
                Objects.equals(content, that.content) &&
                Objects.equals(sender, that.sender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, content, sender);
    }

    @Override
    public String toString() {
        String text = content == null ? "" : ": " + content;
        return type + " @ " + sender + text;
    }
}
