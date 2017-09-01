package ru.litemn.ok.graph.objects.user;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import javax.annotation.Nullable;

/**
 *
 */
public class Subscription {

    private long time;
    private String url;

    public Subscription(long time, String url) {
        this.time = time;
        this.url = url;
    }

    public long getTime() {
        return time;
    }

    @Nullable
    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subscription)) return false;
        Subscription that = (Subscription) o;
        return time == that.time &&
                Objects.equal(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(time, url);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("time", time)
                .add("url", url)
                .toString();
    }
}
