package ru.litemn.ok.graph.requests.user;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.apache.http.impl.client.CloseableHttpClient;
import ru.litemn.ok.graph.objects.user.Subscriptions;
import ru.litemn.ok.graph.requests.AbstractGetRequest;

import java.lang.reflect.Type;

/**
 * https://apiok.ru/dev/graph_api/methods/graph.user/graph.user.subscriptions/get
 */
public class SubscriptionsRequest extends AbstractGetRequest<Subscriptions> {

    public SubscriptionsRequest(Gson gson, CloseableHttpClient client, String token) {
        super(gson, client, token);
    }

    @Override
    protected String getEndpoint() {
        return "/me/subscriptions";
    }

    @Override
    protected Type getType() {
        return new TypeToken<Subscriptions>(){}.getType();
    }
}
