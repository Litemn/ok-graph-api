package ru.litemn.ok.graph.objects.user;

import com.google.gson.annotations.SerializedName;

/**
 * Action in chat
 */
public class ChatAction {

    @SerializedName("message")
    private Object chatControl;
    private Recipient recipient;

    public ChatAction(Object chatControl, Recipient recipient) {
        this.chatControl = chatControl;
        this.recipient = recipient;
    }

    public Object getChatControl() {
        return chatControl;
    }

    public Recipient getRecipient() {
        return recipient;
    }
}
