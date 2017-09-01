package ru.litemn.ok.graph.objects.user;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;
import ru.litemn.ok.graph.objects.ApiResponse;


/**
 * Created by roman.ivanitsky on 01.09.17.
 */
public class MessagesActionResult extends ApiResponse {

   @SerializedName("recipient_id")
   private String recipientId;
   @SerializedName("message_id")
   private String messageId;

    public String getRecipientId() {
        return recipientId;
    }

    public String getMessageId() {
        return messageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MessagesActionResult)) return false;
        if (!super.equals(o)) return false;
        MessagesActionResult that = (MessagesActionResult) o;
        return Objects.equal(recipientId, that.recipientId) &&
                Objects.equal(messageId, that.messageId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), recipientId, messageId);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("recipientId", recipientId)
                .add("message_id", messageId)
                .toString();
    }
}
