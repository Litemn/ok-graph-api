package ru.litemn.ok.graph.requests.user;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.http.impl.client.CloseableHttpClient;
import ru.litemn.ok.graph.objects.user.Info;
import ru.litemn.ok.graph.requests.AbstractGetRequest;

import java.lang.reflect.Type;


/**
 * https://apiok.ru/dev/graph_api/methods/graph.user/graph.user.info/
 */
public class InfoRequest extends AbstractGetRequest<Info> {

    public InfoRequest(Gson gson, CloseableHttpClient client, String token) {
        super(gson, client, token);
    }

    @Override
    protected String getEndpoint() {
        return "/me/info/";
    }

    @Override
    protected Type getType() {
        return new TypeToken<Info>(){}.getType();
    }
}
