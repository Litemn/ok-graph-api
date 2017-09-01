package ru.litemn.ok.graph.objects.user;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;
import ru.litemn.ok.graph.objects.ApiResponse;

/**
 * Token info response
 */
public class Info extends ApiResponse {
    private String name;
    @SerializedName("group_id")
    private String groupId;

    public String getName() {
        return name;
    }

    public String getGroupId() {
        return groupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Info)) return false;
        if (!super.equals(o)) return false;
        Info info = (Info) o;
        return Objects.equal(name, info.name) &&
                Objects.equal(groupId, info.groupId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), name, groupId);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("groupId", groupId)
                .toString();
    }
}
