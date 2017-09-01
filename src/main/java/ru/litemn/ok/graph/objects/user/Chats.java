package ru.litemn.ok.graph.objects.user;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import ru.litemn.ok.graph.objects.ApiResponse;

import java.util.List;

/**
 * Chats info response
 */
public class Chats extends ApiResponse {

    private List<Chat> chats;

    private String marker;

    public List<Chat> getChats() {
        return chats;
    }

    public String getMarker() {
        return marker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chats)) return false;
        if (!super.equals(o)) return false;
        Chats chats1 = (Chats) o;
        return Objects.equal(chats, chats1.chats) &&
                Objects.equal(marker, chats1.marker);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), chats, marker);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("chats", chats)
                .add("marker", marker)
                .toString();
    }
}
