package ru.litemn.ok.graph.requests.user;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.apache.http.impl.client.CloseableHttpClient;
import ru.litemn.ok.graph.objects.SimpleResponse;
import ru.litemn.ok.graph.objects.user.Subscribe;
import ru.litemn.ok.graph.requests.AbstractPostRequest;

import java.lang.reflect.Type;

/**
 * https://apiok.ru/dev/graph_api/methods/graph.user/graph.user.subscribe/post
 */
public class SubscribeRequest extends AbstractPostRequest<SimpleResponse> {

    private final Subscribe subscribe;

    public SubscribeRequest(Gson gson, CloseableHttpClient client, String token, String webHook) {
        super(gson, client, token);
        this.subscribe = new Subscribe(webHook);
    }

    protected String getEndpoint() {
        return "/me/subscribe";
    }

    protected Type getType() {
        return new TypeToken<SimpleResponse>(){}.getType();
    }

    protected String getPayload() {
        return getGson().toJson(subscribe);
    }
}
