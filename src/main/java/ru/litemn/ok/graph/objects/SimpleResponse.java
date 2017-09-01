package ru.litemn.ok.graph.objects;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * Simple api response
 */
public class SimpleResponse extends ApiResponse {

    private boolean success;

    public boolean isSuccess() {
        return success;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleResponse)) return false;
        SimpleResponse that = (SimpleResponse) o;
        return success == that.success;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(success);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("success", success)
                .toString();
    }
}
