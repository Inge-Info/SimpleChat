package chatProject.model.messages;

import chatProject.model.user.UserInfo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * A model for a message sent in the chat.
 * A message has a content (of a generic type T), a unique ID and a sender.
 * @param <T> the type of messages in the chat
 */
public class Message<T> {

    /**
     * The ID of the message (unique).
     */
    private final int id;
    /**
     * The sender of the message.
     */
    private final MessageOwnerConcrete sender;
    /**
     * The content of the message.
     */
    private final T content;
    /**
     * Generate unique id
     */
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger();

    public Message(UserInfo sender, T content) {
        this.id = ID_GENERATOR.getAndIncrement();
        this.sender = (sender == null) ? null : new MessageOwnerConcrete(sender.getAccount(), sender.getCurrentStatus());
        this.content = content;
    }

    /**
     * Gets the ID of the message.
     * @return the message unique ID
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the sender of the message.
     * @return the user who sent the message
     */
    public UserInfo getSender() {
        return sender;
    }

    /**
     * Gets the content of the message.
     * @return the message content
     */
    public T getMessage() {
        return content;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", sender=" + sender +
                ", content=" + content +
                '}';
    }

}
