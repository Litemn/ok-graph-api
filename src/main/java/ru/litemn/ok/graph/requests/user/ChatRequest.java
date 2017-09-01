package ru.litemn.ok.graph.requests.user;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.http.impl.client.CloseableHttpClient;
import ru.litemn.ok.graph.objects.user.Chat;
import ru.litemn.ok.graph.requests.AbstractGetRequest;

import java.lang.reflect.Type;

/**
 * https://apiok.ru/dev/graph_api/methods/graph.user/graph.user.chat/get
 */
public class ChatRequest extends AbstractGetRequest<Chat> {


    public ChatRequest(Gson gson, CloseableHttpClient client, String token, String chatId) {
        super(gson, client, token);
        addParam("chat_id", chatId);
    }

    @Override
    protected String getEndpoint() {
        return "/me/chat";
    }

    @Override
    protected Type getType() {
        return new TypeToken<Chat>(){}.getType();
    }
}
