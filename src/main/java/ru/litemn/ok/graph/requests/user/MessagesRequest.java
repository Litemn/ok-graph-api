package ru.litemn.ok.graph.requests.user;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.apache.http.impl.client.CloseableHttpClient;
import ru.litemn.ok.graph.objects.user.Messages;
import ru.litemn.ok.graph.requests.AbstractGetRequest;

import java.lang.reflect.Type;

/**
 * https://apiok.ru/dev/graph_api/methods/graph.user/graph.user.messages/get
 */
public class MessagesRequest extends AbstractGetRequest<Messages> {


    public MessagesRequest(Gson gson, CloseableHttpClient client, String token, String chatId, long from, long to, long count) {
        super(gson, client, token);
        addParam("chat_id", chatId);
        addParam("from", from);
        addParam("to", to);
        addParam("count", count);
    }

    public MessagesRequest(Gson gson, CloseableHttpClient client, String token, String chatId) {
        super(gson, client, token);
        addParam("chat_id", chatId);
    }

    @Override
    protected String getEndpoint() {
        return "/me/messages";
    }

    @Override
    protected Type getType() {
        return new TypeToken<Messages>(){}.getType();
    }
}
