package ru.litemn.ok.graph.requests;

import com.google.common.base.Preconditions;
import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.litemn.ok.graph.objects.ApiResponse;

import java.io.IOException;

/**
 * Abstract post request
 */
public abstract class AbstractPostRequest<T extends ApiResponse> extends AbstractRequest {
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractPostRequest.class);

    public AbstractPostRequest(Gson gson, CloseableHttpClient client, String token) {
        super(gson, client, token);
    }

    public T execute() {
        HttpPost post = new HttpPost(getUrl());
        post.setEntity(new StringEntity(getPayload(), ContentType.APPLICATION_JSON));
        try(CloseableHttpResponse execute = getClient().execute(post)) {
            int statusCode = execute.getStatusLine().getStatusCode();
            Preconditions.checkArgument(statusCode == 200, "Status code " + statusCode);
            Header errorHeader = execute.getFirstHeader("invocation-error");
            if (null != errorHeader) {
                throw new IllegalStateException("Error code: " + errorHeader.getValue() + ". https://apiok.ru/dev/errors");
            }
            String json = IOUtils.toString(execute.getEntity().getContent());
            LOGGER.debug("Json {}", json);
            return getGson().fromJson(json, getType());
        } catch (IOException e) {
            LOGGER.error("Error execute post to " + getEndpoint(), e);
            throw new IllegalStateException(e);
        }
    }

    protected abstract String getPayload();

}
