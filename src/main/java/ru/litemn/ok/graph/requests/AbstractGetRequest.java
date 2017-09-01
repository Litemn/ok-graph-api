package ru.litemn.ok.graph.requests;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.litemn.ok.graph.objects.ApiResponse;

import java.io.IOException;

/**
 * Abstract get request
 */
public abstract class AbstractGetRequest <T extends ApiResponse> extends AbstractRequest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractGetRequest.class);

    public AbstractGetRequest(Gson gson, CloseableHttpClient client, String token) {
        super(gson, client, token);
    }

    public T execute() {
        HttpGet get = new HttpGet(getUrl());
        try(CloseableHttpResponse execute = getClient().execute(get)) {
            int statusCode = execute.getStatusLine().getStatusCode();
            Header errorHeader = execute.getFirstHeader("invocation-error");
            if (null != errorHeader) {
                throw new IllegalStateException("Error code: " + errorHeader.getValue() + ". https://apiok.ru/dev/errors");
            }
            Preconditions.checkArgument(statusCode == 200, "Status code = " + statusCode);
            String json = IOUtils.toString(execute.getEntity().getContent());
            return getGson().fromJson(json, getType());
        } catch (IOException e) {
            LOGGER.error("Error execute get to " + getUrl(), e);
            throw new IllegalStateException(e);
        }
    }


}
