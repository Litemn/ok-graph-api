package ru.litemn.ok.graph.objects.user;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import ru.litemn.ok.graph.objects.ApiResponse;

import java.util.List;

/**
 * Messages response
 */
public class Messages extends ApiResponse {

    private List<MessageInfo> messages;

    public List<MessageInfo> getMessages() {
        return messages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Messages)) return false;
        if (!super.equals(o)) return false;
        Messages messages1 = (Messages) o;
        return Objects.equal(messages, messages1.messages);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), messages);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("messages", messages)
                .toString();
    }
}
