package ru.litemn.ok.graph.objects.user;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 *
 */
public class Subscribe {

    private String url;

    public Subscribe(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("url", url)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subscribe)) return false;
        Subscribe subscribe = (Subscribe) o;
        return Objects.equal(url, subscribe.url);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(url);
    }
}
