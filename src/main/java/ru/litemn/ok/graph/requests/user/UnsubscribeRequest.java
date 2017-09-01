package ru.litemn.ok.graph.requests.user;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.http.impl.client.CloseableHttpClient;
import ru.litemn.ok.graph.objects.SimpleResponse;
import ru.litemn.ok.graph.objects.user.Subscribe;
import ru.litemn.ok.graph.requests.AbstractPostRequest;

import java.lang.reflect.Type;

/**
 * https://apiok.ru/dev/graph_api/methods/graph.user/graph.user.unsubscribe/post
 */
public class UnsubscribeRequest extends AbstractPostRequest<SimpleResponse> {

    private final Subscribe subscribe;

    public UnsubscribeRequest(Gson gson, CloseableHttpClient client, String token, String url) {
        super(gson, client, token);
        this.subscribe = new Subscribe(url);
    }

    @Override
    protected String getEndpoint() {
        return "/me/unsubscribe";
    }

    @Override
    protected Type getType() {
        return new TypeToken<SimpleResponse>(){}.getType();
    }

    @Override
    protected String getPayload() {
        return getGson().toJson(subscribe);
    }
}
