package ru.litemn.ok.graph.objects.user;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import ru.litemn.ok.graph.objects.ApiResponse;

import java.util.List;

/**
 * Subscriptions response
 */
public class Subscriptions extends ApiResponse {

    private List<Subscription> subscriptions;

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subscriptions)) return false;
        Subscriptions that = (Subscriptions) o;
        return Objects.equal(subscriptions, that.subscriptions);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(subscriptions);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("subscriptions", subscriptions)
                .toString();
    }
}
