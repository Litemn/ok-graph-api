package ru.litemn.ok.graph.requests;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import ru.litemn.ok.graph.objects.ApiResponse;

import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.List;

/**
 * Abstract request
 */
public abstract class AbstractRequest<T extends ApiResponse> {

    private Gson gson;
    private CloseableHttpClient client;
    private String token;
    private List<NameValuePair> params;

    public AbstractRequest(Gson gson, CloseableHttpClient client, String token) {
        this.gson = gson;
        this.client = client;
        this.token = token;
        this.params = Lists.newArrayList();
        addParam("access_token", token);
    }

    public abstract T execute();

    protected abstract String getEndpoint();

    protected Gson getGson() {
        return gson;
    }

    protected CloseableHttpClient getClient() {
        return client;
    }

    protected String getToken() {
        return token;
    }

    protected abstract Type getType();

    protected String getUrl() {
        return "https://api.ok.ru/graph" + getEndpoint() + "?" + getQueryString();
    }

    protected List<NameValuePair> getParams() {
        return params;
    }

    protected String getQueryString() {
        return URLEncodedUtils.format(getParams(), Charset.forName("utf-8"));
    }

    protected void addParam(String key, String value) {
        params.add(new BasicNameValuePair(key, value));
    }

    protected void addParam(String key, long value) {
        params.add(new BasicNameValuePair(key, String.valueOf(value)));
    }

    protected void addParam(String key, int value) {
        params.add(new BasicNameValuePair(key, String.valueOf(value)));
    }

}
