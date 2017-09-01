package ru.litemn.ok.graph.requests.user;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.http.impl.client.CloseableHttpClient;
import ru.litemn.ok.graph.objects.user.Chats;
import ru.litemn.ok.graph.requests.AbstractGetRequest;

import java.lang.reflect.Type;

/**
 * https://apiok.ru/dev/graph_api/methods/graph.user/graph.user.chats/get
 */
public class ChatsRequest extends AbstractGetRequest<Chats> {


    public ChatsRequest(Gson gson, CloseableHttpClient client, String token, String marker, int count) {
        super(gson, client, token);
        addParam("marker", marker);
        addParam("count", String.valueOf(count));
    }

    public ChatsRequest(Gson gson, CloseableHttpClient client, String token, int count) {
        super(gson, client, token);
        addParam("count", String.valueOf(count));
    }

    public ChatsRequest(Gson gson, CloseableHttpClient client, String token) {
        super(gson, client, token);
    }


    @Override
    protected String getEndpoint() {
        return "/me/chats";
    }

    @Override
    protected Type getType() {
        return new TypeToken<Chats>(){}.getType();
    }
}
