package ru.litemn.ok.graph.objects.user;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;

/**
 *
 */
public class Sender {

    private String name;
    @SerializedName("user_id")
    private String userId;

    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sender)) return false;
        Sender sender = (Sender) o;
        return Objects.equal(name, sender.name) &&
                Objects.equal(userId, sender.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, userId);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("userId", userId)
                .toString();
    }
}
