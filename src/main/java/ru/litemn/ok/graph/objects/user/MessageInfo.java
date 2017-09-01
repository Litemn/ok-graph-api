package ru.litemn.ok.graph.objects.user;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 *
 */
public class MessageInfo {
    private Sender sender;
    private Recipient recipient;
    private Message message;
    private long timestamp;

    public Sender getSender() {
        return sender;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public Message getMessage() {
        return message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MessageInfo)) return false;
        MessageInfo that = (MessageInfo) o;
        return timestamp == that.timestamp &&
                Objects.equal(sender, that.sender) &&
                Objects.equal(recipient, that.recipient) &&
                Objects.equal(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(sender, recipient, message, timestamp);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("sender", sender)
                .add("recipient", recipient)
                .add("message", message)
                .add("timestamp", timestamp)
                .toString();
    }
}
