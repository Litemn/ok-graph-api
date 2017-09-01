package ru.litemn.ok.graph.requests.user;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.apache.http.impl.client.CloseableHttpClient;
import ru.litemn.ok.graph.objects.user.ChatAction;
import ru.litemn.ok.graph.objects.user.MessagesActionResult;
import ru.litemn.ok.graph.requests.AbstractPostRequest;

import java.lang.reflect.Type;

/**
 * Created by roman.ivanitsky on 01.09.17.
 */
public class MessagesActionRequest extends AbstractPostRequest<MessagesActionResult> {

    private ChatAction action;

    public MessagesActionRequest(Gson gson, CloseableHttpClient client, String token, ChatAction action) {
        super(gson, client, token);
        this.action = action;
    }

    @Override
    protected String getEndpoint() {
        return "/me/messages";
    }

    @Override
    protected Type getType() {
        return new TypeToken<MessagesActionResult>(){}.getType();
    }

    @Override
    protected String getPayload() {
        return getGson().toJson(action);
    }
}
