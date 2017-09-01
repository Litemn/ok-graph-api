package ru.litemn.ok.graph.objects.user;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;

/**
 *
 */
public class Recipient {

    public Recipient(String chatId) {
        this.chatId = chatId;
    }

    @SerializedName("chat_id")
    private String chatId;

    public String getChatId() {
        return chatId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recipient)) return false;
        Recipient recipient = (Recipient) o;
        return Objects.equal(chatId, recipient.chatId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(chatId);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("chatId", chatId)
                .toString();
    }
}
