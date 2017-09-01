package ru.litemn.ok.graph.objects.user;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;
import ru.litemn.ok.graph.objects.ApiResponse;

import java.util.Map;

/**
 * Chat info response.
 */
public class Chat extends ApiResponse {
    private ChatType type;
    private UserStatus status;
    private String title;
    private String icone;
    private Map<String, Long> participants;
    private long lastEventTime;
    @SerializedName("chat_id")
    private String chatId;
    @SerializedName("owner_id")
    private String ownerId;
    @SerializedName("group_id")
    private String groupId;

    public ChatType getType() {
        return type;
    }

    public UserStatus getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public String getIcone() {
        return icone;
    }

    public Map<String, Long> getParticipants() {
        return participants;
    }

    public long getLastEventTime() {
        return lastEventTime;
    }

    public String getChatId() {
        return chatId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public String getGroupId() {
        return groupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chat)) return false;
        if (!super.equals(o)) return false;
        Chat chat = (Chat) o;
        return lastEventTime == chat.lastEventTime &&
                type == chat.type &&
                status == chat.status &&
                Objects.equal(title, chat.title) &&
                Objects.equal(icone, chat.icone) &&
                Objects.equal(participants, chat.participants) &&
                Objects.equal(chatId, chat.chatId) &&
                Objects.equal(ownerId, chat.ownerId) &&
                Objects.equal(groupId, chat.groupId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), type, status, title, icone, participants, lastEventTime, chatId, ownerId, groupId);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("type", type)
                .add("status", status)
                .add("title", title)
                .add("icone", icone)
                .add("participants", participants)
                .add("lastEventTime", lastEventTime)
                .add("chatId", chatId)
                .add("ownerId", ownerId)
                .add("groupId", groupId)
                .toString();
    }
}
